package com.winson.spring.cloud.initializarstart.service;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.winson.spring.cloud.initializarstart.vo.Weather;
import com.winson.spring.cloud.initializarstart.vo.WeatherResponse;
import com.winson.spring.cloud.initializarstart.vo.WeatherResponse2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
//import java.util.logging.Logger;

@Service
public class WeatherDataServiceImpl implements WeatherDataService{
    private static final String WEATHER_URI = "https://www.tianqiapi.com/free/day?appid=96487964&appsecret=Vv44eULU&";
   // private static final String WEATHER_URI = "http://www.weather.com.cn/data/sk/101190408.html";

    //使用日志
    private final static Logger logger = LoggerFactory.getLogger(WeatherDataServiceImpl.class);

    //Redis缓存超时时间
    private static final long TIME_OUT = 18000L;

    @Autowired
    //@Resource
    private RestTemplate restTemplate;

    //导入Redis
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public WeatherResponse2 getDataByCityId(String cityId) {
        String uri = WEATHER_URI + "cityid="+ cityId;
        //String uri = WEATHER_URI;
        return this.doGetWeather(uri);
    }

    @Override
    public WeatherResponse2 getDataByCityName(String cityName) {
        String uri = WEATHER_URI + "city="+ cityName;
        //String uri = WEATHER_URI;
        return this.doGetWeather(uri);
    }

    private WeatherResponse2 doGetWeather(String uri){
        String key = uri;
        ObjectMapper mapper = new ObjectMapper();
        WeatherResponse2 resp = null;
        String strBody = null;
        ValueOperations<String,String> ops = stringRedisTemplate.opsForValue();
        //先查缓存，缓存有数据就取缓存中的数据

        if (stringRedisTemplate.hasKey(key)){
            logger.info("Redis里面有数据，key="+ key);
            strBody = ops.get(key);
        } else {
            logger.info("Redis里面没有数据");
            //缓存没有，再调用服务接口来获取

            ResponseEntity<String> respString = restTemplate.getForEntity(uri, String.class);
            if(respString.getStatusCodeValue() == 200){
                strBody = respString.getBody();
            }

            ops.set(key,strBody, TIME_OUT, TimeUnit.SECONDS);
        }


        try {
            resp = mapper.readValue(strBody, WeatherResponse2.class);
        } catch (IOException e){
            //e.printStackTrace();
            logger.error("Error!",e);
        }

        return resp;
    }

    @Override
    public void syncDateByCityId(String cityId) {
        String uri = WEATHER_URI + "cityid="+ cityId;
        saveWeatherData(uri);
    }

    /**
     * 获取天气数据，放入缓存
     * @param uri
     */
    private void saveWeatherData(String uri){
        String key = uri;
        String strBody = null;
        ValueOperations<String,String> ops = stringRedisTemplate.opsForValue();

        ResponseEntity<String> respString = restTemplate.getForEntity(uri, String.class);
        if(respString.getStatusCodeValue() == 200){
            strBody = respString.getBody();
        }

        ops.set(key,strBody, TIME_OUT, TimeUnit.SECONDS);
    }
}
