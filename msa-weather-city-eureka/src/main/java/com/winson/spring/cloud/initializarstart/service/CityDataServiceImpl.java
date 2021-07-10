package com.winson.spring.cloud.initializarstart.service;

import com.winson.spring.cloud.initializarstart.util.XmlBuilder;
import com.winson.spring.cloud.initializarstart.vo.City;
import com.winson.spring.cloud.initializarstart.vo.CityList;
import org.springframework.core.io.ClassPathResource;

import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

/**
 * @author ：Winson
 * @date ：Created in 2021/7/7 17:25
 * @description：
 * @modified By：
 * @version: $
 */
@Service
public class CityDataServiceImpl implements CityDataService {
    @Override
    public List<City> listCity() throws Exception {

        //读取XML文件
        Resource resource = new ClassPathResource("citylist.xml");

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(resource.getInputStream(),"utf-8"));
        StringBuffer buffer = new StringBuffer();
        String line = "";

        while ((line = bufferedReader.readLine()) != null){
            buffer.append(line);
        }

        bufferedReader.close();

        //xml转java对象
        CityList cityList = null;
        try {
            cityList = (CityList) XmlBuilder.xmlStrToObject(CityList.class, buffer.toString());
        } catch (Exception e){
            e.printStackTrace();
        }

        return cityList.getCityList();
    }
}
