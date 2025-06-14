package com.example.RishiTraders.BookMyShow;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
@Builder
@Data
@EqualsAndHashCode(of = "movieName")
public class Movie {
    private Integer movieId;
    private String movieName;
    private Integer movieDuration;
}
