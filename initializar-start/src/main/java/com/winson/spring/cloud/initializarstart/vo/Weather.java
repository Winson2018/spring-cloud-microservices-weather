package com.winson.spring.cloud.initializarstart.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

//@Data
//@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Weather implements Serializable {
    private static final long serialVersionUID = 1L;

/*    private String cityid;
    private String city;
    private String update_time;
    private String wea;
    private String wea_img;
    private String tem;
    private String tem_day;
    private String tem_night;
    private String win;
    private String win_speed;
    private String win_meter;
    private String air;*/

    private String city;
    private String cityid;
    private String temp;
    private String wd;
    private String ws;
    private String sd;
    private String ap;
    private String njd;
    private String wse;
    private String time;
    private String sm;
    private String isRadar;
    private String radar;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCityid() {
        return cityid;
    }

    public void setCityid(String cityid) {
        this.cityid = cityid;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public String getWd() {
        return wd;
    }

    public void setWd(String wd) {
        this.wd = wd;
    }

    public String getWs() {
        return ws;
    }

    public void setWs(String ws) {
        this.ws = ws;
    }

    public String getSd() {
        return sd;
    }

    public void setSd(String sd) {
        this.sd = sd;
    }

    public String getAp() {
        return ap;
    }

    public void setAp(String ap) {
        this.ap = ap;
    }

    public String getNjd() {
        return njd;
    }

    public void setNjd(String njd) {
        this.njd = njd;
    }

    public String getWse() {
        return wse;
    }

    public void setWse(String wse) {
        this.wse = wse;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getSm() {
        return sm;
    }

    public void setSm(String sm) {
        this.sm = sm;
    }

    public String getIsRadar() {
        return isRadar;
    }

    public void setIsRadar(String isRadar) {
        this.isRadar = isRadar;
    }

    public String getRadar() {
        return radar;
    }

    public void setRadar(String radar) {
        this.radar = radar;
    }

    /*     "weatherinfo": {
        "city": "太仓",
                "cityid": "101190408",
                "temp": "22.8",
                "njd": "暂无实况",
                "time": "17:55",
                "sm": "3.2",
                "isRadar": "0",
                "wd": null,
                "ws": null,
                "radar": null,
                "wse": null,
                "sd": null,
                "ap": null
    }*/


}

/*{"weatherinfo":{
    "city":"太仓",
        "cityid":"101190408",
        "temp":"22.8",
        "WD":"东风",
        "WS":"小于3级",
        "SD":"81%",
        "AP":"1005.5hPa",
        "njd":"暂无实况",
        "WSE":"<3",
        "time":"17:55",
        "sm":"3.2",
        "isRadar":"0",
        "Radar":""}
}*/

/*
{"cityid":"101010100",
        "city":"\u5317\u4eac",
        "update_time":"10:16",
        "wea":"\u591a\u4e91",
        "wea_img":"yun",
        "tem":"28",
        "tem_day":"33",
        "tem_night":"23",
        "win":"\u897f\u5317\u98ce",
        "win_speed":"7\u7ea7",
        "win_meter":"55km\/h",
        "air":"51"}*/
