package com.winson.spring.cloud.initializarstart.service;

import com.winson.spring.cloud.initializarstart.vo.Weather;
import com.winson.spring.cloud.initializarstart.vo.WeatherResponse;
import com.winson.spring.cloud.initializarstart.vo.WeatherResponse2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ：Winson
 * @date ：Created in 2021/7/7 18:51
 * @description：
 * @modified By：
 * @version: $
 */

@Service
public class WeatherReportServiceImpl implements WeatherReportService{

    @Override
    public WeatherResponse2 getDataByCityId(String cityId) {
        //TODO 改为由天气数据API微服务来提供数据
        //WeatherResponse2 response = weatherDataService.getDataByCityId(cityId);
        //return response;
        WeatherResponse2 response2 = new WeatherResponse2();
        response2.setCity("深圳");
        response2.setCityid("101280601");
        response2.setAir("良好");
        response2.setTem("25");
        response2.setWea("50");
        response2.setTem_day("28");
        response2.setTem_night("24");
        response2.setWin("北风");
        return response2;
    }


}
