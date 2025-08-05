package com.example.RishiTraders.BookMyShow;

import lombok.Data;

import java.util.List;

@Data
public class Booking {
    private String bookingId;
    private Show show;
    private List<Seat> seatList;
    private Boolean bookingStatus;
}
