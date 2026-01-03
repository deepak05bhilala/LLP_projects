package com.example;

public class StatisticsDisplay implements Observer, Display{
    private Integer humidity;
    private Integer wind;
    private WeatherData weatherData;

    public StatisticsDisplay(WeatherData weatherData){
        this.weatherData=weatherData;
        weatherData.addObserver(this);
    }

    @Override
    public void update(Integer humidity, Integer wind) {
        this.wind = wind;
        this.humidity = humidity;
        display();
    }

    @Override
    public void display() {
        System.out.println("Humidity= "+humidity+" Wind= "+wind);
    }
}
