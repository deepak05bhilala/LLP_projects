package com.example.RishiTraders.ParkingLot.Vehicle;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Data
public abstract class Vehicle {
    private VehicleMetaData vehicleMetaData;
    private Map<String, Object> otherAttributes = new HashMap<>();
    public Vehicle(){

    }
}
