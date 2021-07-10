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
    @Autowired
    private WeatherDataService weatherDataService;

    @Override
    public WeatherResponse2 getDataByCityId(String cityId) {
        WeatherResponse2 response = weatherDataService.getDataByCityId(cityId);
        return response;
    }


}
