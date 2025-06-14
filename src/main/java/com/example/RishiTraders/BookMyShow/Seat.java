package com.example.RishiTraders.BookMyShow;


import com.example.RishiTraders.BookMyShow.Enum.SeatType;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Seat {
    private Integer seatNumber;
    private SeatType seatType;
    private Integer seatPrice;
}
