package com.example.RishiTraders.ParkingLot;

import lombok.Data;

@Data
public class ParkingLotService {
    private String parkingLotId;
    private Integer initialFloors;
    private Integer totalSlots;
    private Integer highestFloorNumber;
}
