package com.example;

import java.util.ArrayList;
import java.util.List;

public class WeatherData implements Subject{
    List<Observer> observerList = new ArrayList<>();
    Integer humidity;
    Integer wind;

    public void setMeasurements(Integer humidity,Integer wind) {
        this.humidity = humidity;
        this.wind = wind;
        notifyObserver();
    }

    @Override
    public void addObserver(Observer o) {
        observerList.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        int i = observerList.indexOf(o);
        if (i >= 0) {
            observerList.remove(i);
        }
    }

    @Override
    public void notifyObserver() {
        for(int i =0;i< observerList.size();i++){
            Observer o = observerList.get(i);
            o.update(humidity,wind);
        }

    }
}
