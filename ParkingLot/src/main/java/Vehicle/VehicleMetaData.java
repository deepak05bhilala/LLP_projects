package com.example.RishiTraders.ParkingLot.Vehicle;

import lombok.Data;

import java.util.Date;

@Data
public class VehicleMetaData {
    private String vehicleType;
    private String registrationNumber;
    private String colour;
    private Date enterDateTime;
    private Date exitDateTime;
}

