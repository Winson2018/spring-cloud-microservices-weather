package com.winson.spring.cloud.initializarstart.service;

import com.winson.spring.cloud.initializarstart.vo.City;
import com.winson.spring.cloud.initializarstart.vo.WeatherResponse2;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * City Client.
 * 
 * @since 1.0.0 2017年11月28日
 * @author
 */
@FeignClient(name = "msa-weather-eureka-client-zuul",fallback = DataClientFallback.class)
public interface DataClient {
	/**
	 * 获取城市列表,经过zuul网关来转发请求
	 * @return
	 * @throws Exception
	 */
	@GetMapping("/city/cities")
	List<City> listCity() throws Exception;

	/**
	 * 根据城市ID查询天气数据
	 * @param cityId
	 * @return
	 */
	@GetMapping("/data/weather/cityId/{cityId}")
	WeatherResponse2 getDataByCityId(@PathVariable("cityId") String cityId);
}
