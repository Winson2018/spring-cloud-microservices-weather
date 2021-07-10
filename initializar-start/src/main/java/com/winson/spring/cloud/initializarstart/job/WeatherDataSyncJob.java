package com.winson.spring.cloud.initializarstart.job;

import com.winson.spring.cloud.initializarstart.service.CityDataService;
import com.winson.spring.cloud.initializarstart.service.WeatherDataService;
import com.winson.spring.cloud.initializarstart.vo.City;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.List;

//import java.util.logging.Logger;

public class WeatherDataSyncJob extends QuartzJobBean {

    private final static Logger logger = LoggerFactory.getLogger(WeatherDataSyncJob.class);

    @Autowired
    private CityDataService cityDataService;

    @Autowired
    private WeatherDataService weatherDataService;

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        logger.info("WeatherDataSyncJob start!");

        //获取城市列表
        List<City> cityList = null;

        try {
           cityList = cityDataService.listCity();
        } catch (Exception e) {
            logger.error("Exception:" , e);
        }

        //遍历城市列表
        for (City city : cityList) {
            String cityId = city.getCityId();
            logger.info("WeatherDataSyncJob, city id ="+ cityId);

            weatherDataService.syncDateByCityId(cityId);
        }

        logger.info("WeatherDataSyncJob, end!");
    }




}
