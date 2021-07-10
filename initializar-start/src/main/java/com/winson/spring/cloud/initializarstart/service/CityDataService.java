package com.winson.spring.cloud.initializarstart.service;

import com.winson.spring.cloud.initializarstart.vo.City;

import java.util.List;

/**
 * @author ：Winson
 * @date ：Created in 2021/7/7 17:23
 * @description：
 * @modified By：
 * @version: $
 */
public interface CityDataService {

    /**
     * 获取city列表
     * @return
     * @throws Exception
     */
    List<City> listCity() throws Exception;
}
