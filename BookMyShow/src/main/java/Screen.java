package com.example.RishiTraders.BookMyShow;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Screen {
    private Integer screenId;
    private Integer totalCapacity;
    private Integer totalOccupancy;
    List<Seat> seatList;
}
