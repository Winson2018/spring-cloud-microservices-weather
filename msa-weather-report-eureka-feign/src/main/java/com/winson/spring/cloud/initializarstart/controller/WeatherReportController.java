package com.winson.spring.cloud.initializarstart.controller;

import com.winson.spring.cloud.initializarstart.service.CityClient;
import com.winson.spring.cloud.initializarstart.service.WeatherReportService;
import com.winson.spring.cloud.initializarstart.vo.City;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/report")
public class WeatherReportController {
    private final static Logger logger = LoggerFactory.getLogger(WeatherReportController.class);

    @Autowired
    private WeatherReportService weatherReportService;

    @Autowired
    private CityClient cityClient;

    @GetMapping("/cityId/{cityId}")
    public ModelAndView  getReportByCityId(@PathVariable("cityId") String cityId , Model model) throws Exception{
        // 改为由城市数据API微服务来提供服务

        List<City> cityList = cityClient.listCity();
        /*List<City> cityList = null;
        try{
            cityList = new ArrayList<>();
            City city = new City();
            city.setCityId("101280601");
            city.setCityName("深圳");
            cityList.add(city);
        } catch (Exception e){
            logger.error("Exception!",e);
        }*/

        model.addAttribute("title","Winson天气预报系统");
        model.addAttribute("cityId",cityId);
        model.addAttribute("cityList",cityList);
        model.addAttribute("report",weatherReportService.getDataByCityId(cityId));

        return new ModelAndView("weather/report","reportModel",model);
    }

}
