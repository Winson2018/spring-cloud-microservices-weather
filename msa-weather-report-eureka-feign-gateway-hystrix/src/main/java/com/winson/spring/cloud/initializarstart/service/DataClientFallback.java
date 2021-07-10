package com.winson.spring.cloud.initializarstart.service;

import com.winson.spring.cloud.initializarstart.vo.City;
import com.winson.spring.cloud.initializarstart.vo.WeatherResponse2;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：Winson
 * @date ：Created in 2021/7/9 15:11
 * @description：服务熔断的回调函数
 * @modified By：
 * @version: $
 */
@Component
public class DataClientFallback implements DataClient{
    @Override
    public List<City> listCity() throws Exception {
        List<City> cityList = new ArrayList<>();
        City city1 = new City();
        city1.setCityName("广州");
        city1.setCityId("101280101");
        cityList.add(city1);
        City city2 = new City();
        city2.setCityName("番禺");
        city2.setCityId("101280102");
        cityList.add(city2);
        return cityList;
    }

    @Override
    public WeatherResponse2 getDataByCityId(String cityId) {
        return null;
    }
}
