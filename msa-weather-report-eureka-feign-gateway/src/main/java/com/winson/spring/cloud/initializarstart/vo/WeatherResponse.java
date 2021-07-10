package com.winson.spring.cloud.initializarstart.vo;

import java.io.Serializable;

public class WeatherResponse implements Serializable {

    private static final long serialVersionUID = 1L;
    private Weather weatherinfo;

    public Weather getWeatherinfo() {
        return weatherinfo;
    }

    public void setWeatherinfo(Weather weatherinfo) {
        this.weatherinfo = weatherinfo;
    }
}
