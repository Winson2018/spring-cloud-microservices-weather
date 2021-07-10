package com.winson.spring.cloud.initializarstart.controller;

import com.winson.spring.cloud.initializarstart.service.CityDataService;
import com.winson.spring.cloud.initializarstart.vo.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author ：Winson
 * @date ：Created in 2021/7/8 14:23
 * @description：城市服务接口
 * @modified By：
 * @version: $
 */
@RestController
@RequestMapping("/cities")
public class CityController {

    @Autowired
    private CityDataService cityDataService;

    @GetMapping
    public List<City> listCity() throws Exception{
        return cityDataService.listCity();
    }
}
