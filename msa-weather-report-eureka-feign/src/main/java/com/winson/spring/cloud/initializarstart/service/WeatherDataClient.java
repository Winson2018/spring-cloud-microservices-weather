package com.winson.spring.cloud.initializarstart.service;

import com.winson.spring.cloud.initializarstart.vo.WeatherResponse2;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("msa-weather-data-eureka")
public interface WeatherDataClient {

    @GetMapping("/weather/cityId/{cityId}")
    WeatherResponse2 getDataByCityId(@PathVariable("cityId") String cityId);
}
