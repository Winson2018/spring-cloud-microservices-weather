package com.waylau.spring.cloud.weather.service;

//import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author ：Winson
 * @date ：Created in 2021/7/8 21:10
 * @description：
 * @modified By：
 * @version: $
 */
@FeignClient("msa-weather-city-eureka")
public interface CityClient {

    @GetMapping("/cities")
    String listCity();
}
