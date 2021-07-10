package com.winson.spring.cloud.initializarstart.service;

import com.winson.spring.cloud.initializarstart.vo.Weather;
import com.winson.spring.cloud.initializarstart.vo.WeatherResponse;
import com.winson.spring.cloud.initializarstart.vo.WeatherResponse2;

public interface WeatherDataService {

    //根据城市id获取天气数据
    WeatherResponse2 getDataByCityId(String cityId);

    //根据城市名称获取天气数据
    WeatherResponse2 getDataByCityName(String cityName);

}
