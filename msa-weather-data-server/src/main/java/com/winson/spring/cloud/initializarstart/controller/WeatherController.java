package com.winson.spring.cloud.initializarstart.controller;

import com.winson.spring.cloud.initializarstart.service.WeatherDataService;
import com.winson.spring.cloud.initializarstart.vo.WeatherResponse2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("weather")
public class WeatherController {

    @Autowired
    private WeatherDataService weatherDataService;

    @GetMapping("/cityId/{cityId}")
    public WeatherResponse2 getWeatherByCityId(@PathVariable("cityId") String cityId){
        return weatherDataService.getDataByCityId(cityId);
    }

    @GetMapping("/cityName/{cityName}")
    public WeatherResponse2 getWeatherByCityName(@PathVariable("cityName") String cityName){
        return weatherDataService.getDataByCityName(cityName);
    }
}
