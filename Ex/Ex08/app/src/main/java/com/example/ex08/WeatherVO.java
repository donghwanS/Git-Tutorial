package com.example.ex08;

public class WeatherVO {

    private String city;        // 도시명
    private String temp;        // 기온
    private String weather;     // 날씨(맑음, 눈, 비, 구름)

    // 우클릭 > Generate > Constructor

    public WeatherVO(String city, String temp, String weather) {
        this.city = city;
        this.temp = temp;
        this.weather = weather;
    }

    // 우클릭 > Generate > Getter and Setter

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }
}
