package com.winson.spring.cloud.initializarstart.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.TimeUnit;

/**
 * @author ：Winson
 * @date ：Created in 2021/7/8 11:11
 * @description：实现同步城市数据
 * @modified By：
 * @version: $
 */

@Service
public class WeatherDataCollectionServiceImpl implements WeatherDataCollectionService{

    private static final String WEATHER_URI = "https://www.tianqiapi.com/free/day?appid=96487964&appsecret=Vv44eULU&";
    // private static final String WEATHER_URI = "http://www.weather.com.cn/data/sk/101190408.html";

    //使用日志
    //private final static Logger logger = LoggerFactory.getLogger(WeatherDataServiceImpl.class);

    //Redis缓存超时时间
    private static final long TIME_OUT = 18000L;  //把超时时间设长一些，不用经常去拉取数据，只是测试用

    @Autowired
    private RestTemplate restTemplate;

    //导入Redis
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public void syncDataByCityId(String cityId) {
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
