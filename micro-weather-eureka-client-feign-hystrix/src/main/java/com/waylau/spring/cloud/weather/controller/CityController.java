package com.waylau.spring.cloud.weather.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.waylau.spring.cloud.weather.service.CityClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：Winson
 * @date ：Created in 2021/7/8 21:17
 * @description：
 * @modified By：
 * @version: $
 */
@RestController
public class CityController {

    @Autowired
    private CityClient cityClient;

    @GetMapping("/cities")
    @HystrixCommand(fallbackMethod = "defaultCities")  //启用Hystrix断路器
    public String listCity(){
        //通过Feign来查找
        String body = cityClient.listCity();
        return body;
    }

    public String defaultCities(){
        return "City Data Server is Down!";
    }
}
