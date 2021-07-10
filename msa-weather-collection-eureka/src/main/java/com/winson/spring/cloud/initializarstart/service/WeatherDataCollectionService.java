package com.winson.spring.cloud.initializarstart.service;

/**
 * create by: Winson
 * description: 天气采集接口
 * create time:  
 * 
  * @Param: null
 * @return 
 */
public interface WeatherDataCollectionService {

    /**
     * 根据城市id采集数据
     */
    void syncDataByCityId(String cityId);
}
