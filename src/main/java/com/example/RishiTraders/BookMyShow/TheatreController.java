package com.example.RishiTraders.BookMyShow;

import com.example.RishiTraders.BookMyShow.Enum.City;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class TheatreController {
    private Map<City, List<Theatre>> cityTheatreMap =new HashMap<>();
    private Map<String,Theatre> theatreNameMap =new HashMap<>();

    public void addTheatreToCity(Theatre theatre, City city){
        cityTheatreMap.computeIfAbsent(city,key->new ArrayList<>()).add(theatre);
    }
    public Optional<List<Theatre>> getTheatresInCity (City city){
        return Optional.ofNullable(cityTheatreMap.get(city)).filter(list->!list.isEmpty());
    }
    public void addTheatre(String theatreName, Theatre theatre){
        theatreNameMap.put(theatreName.toLowerCase(),theatre);
    }
    public Optional<Theatre> getTheatre(String theatreName){
        return Optional.ofNullable(theatreNameMap.get(theatreName));
    }
}
