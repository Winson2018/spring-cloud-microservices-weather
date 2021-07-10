package com.winson.spring.cloud.initializarstart.service;

import com.winson.spring.cloud.initializarstart.vo.Weather;
import com.winson.spring.cloud.initializarstart.vo.WeatherResponse2;

public interface WeatherReportService {
    /**
     * 根据城市ID查询天气信息
     * @param cityId
     * @return
     */
    WeatherResponse2 getDataByCityId(String cityId);
}
