package com.winson.spring.cloud.initializarstart.job;

import com.winson.spring.cloud.initializarstart.service.CityClient;
import com.winson.spring.cloud.initializarstart.service.WeatherDataCollectionService;
import com.winson.spring.cloud.initializarstart.vo.City;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.ArrayList;
import java.util.List;

//import java.util.logging.Logger;

public class WeatherDataSyncJob extends QuartzJobBean {

    private final static Logger logger = LoggerFactory.getLogger(WeatherDataSyncJob.class);

    //@Autowired
    //private CityDataService cityDataService;

    @Autowired
    //private WeatherDataService weatherDataService;
    private WeatherDataCollectionService weatherDataCollectionService;

    @Autowired
    private CityClient cityClient;

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        logger.info("WeatherDataSyncJob start!");

        //获取城市列表
        //TODO 改为由城市数据API微服务来提供数据
        List<City> cityList = null;

        try {
            //改为由城市数据API微服务来提供
           cityList = cityClient.listCity();

        } catch (Exception e) {
            logger.error("Exception:" , e);
        }

        //遍历城市列表
        int cityNum = 0;
        for (City city : cityList) {
            if (cityNum < 5) {  //一次只拉取5条数据，接口有限制
                String cityId = city.getCityId();
                logger.info("WeatherDataSyncJob, city id =" + cityId);

                //weatherDataService.syncDateByCityId(cityId);
                weatherDataCollectionService.syncDataByCityId(cityId);
            }
            cityNum++;
        }

        logger.info("WeatherDataSyncJob, end!");
    }




}
