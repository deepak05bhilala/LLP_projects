package com.example.RishiTraders.BookMyShow;

import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class Show {
    private Integer showId;
    private Movie movie;
    private Screen screen;
    List<Integer> bookedSeatIdList=new ArrayList<>();
}
