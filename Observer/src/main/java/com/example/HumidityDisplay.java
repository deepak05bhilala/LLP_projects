package com.example;

public class HumidityDisplay implements Observer, Display{
    private Integer humidity;
    private Integer wind;
    private WeatherData weatherData;

    public HumidityDisplay(WeatherData weatherData){
        this.weatherData=weatherData;
        weatherData.addObserver(this);
    }

    @Override
    public void update(Integer humidity,Integer wind) {
        this.humidity= humidity;
        this.wind=wind;
        display();
    }

    @Override
    public void display() {
        System.out.println("Humidity= "+humidity);
    }
}
