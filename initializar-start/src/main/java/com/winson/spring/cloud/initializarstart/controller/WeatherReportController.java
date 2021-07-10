package com.winson.spring.cloud.initializarstart.controller;

import com.winson.spring.cloud.initializarstart.service.CityDataService;
import com.winson.spring.cloud.initializarstart.service.WeatherDataService;
import com.winson.spring.cloud.initializarstart.vo.WeatherResponse2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/report")
public class WeatherReportController {

    @Autowired
    private WeatherDataService weatherDataService;

    @Autowired
    private CityDataService cityDataService;

    @GetMapping("/cityId/{cityId}")
    public ModelAndView  getReportByCityId(@PathVariable("cityId") String cityId , Model model) throws Exception{
        //return weatherDataService.getDataByCityId(cityId);

        model.addAttribute("title","Winson天气预报系统");
        model.addAttribute("cityId",cityId);
        model.addAttribute("cityList",cityDataService.listCity());
        model.addAttribute("report",weatherDataService.getDataByCityId(cityId));

        return new ModelAndView("weather/report","reportModel",model);
    }

}
