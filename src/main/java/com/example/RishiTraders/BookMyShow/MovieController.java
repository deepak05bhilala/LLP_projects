package com.example.RishiTraders.BookMyShow;


import com.example.RishiTraders.BookMyShow.Enum.City;
import lombok.Data;
import org.springframework.stereotype.Component;

import javax.swing.text.html.Option;
import java.util.*;

@Component
public class MovieController {
    private Map<String, Movie> movieMap = new HashMap<>();
    private Map<City,Set<Movie>> cityMovieMap =new HashMap<>();

    public void addMovie(String movieName, Movie movie) {
        movieMap.putIfAbsent(movieName.toLowerCase(), movie);
    }

    public Optional<Movie> getMovie(String movieName) {
        return Optional.ofNullable(movieMap.get(movieName.toLowerCase()));
    }

    public void addMovieToCity(City city,Movie movie){
        cityMovieMap.computeIfAbsent(city,key->new HashSet<>()).add(movie);
    }

    public Optional<Set<Movie>> getMovieByCity(City city){
        return Optional.ofNullable(cityMovieMap.get(city)).filter(set-> !set.isEmpty());
    }
}
