package com.example.RishiTraders.ParkingLot.Vehicle.ConcreteVehicles;

import com.example.RishiTraders.ParkingLot.Vehicle.Vehicle;
import com.example.RishiTraders.ParkingLot.Vehicle.VehicleMetaData;
import lombok.Data;

import java.util.Date;
import java.util.Map;
@Data
public class Truck extends Vehicle {
    public Truck(VehicleMetaData vehicleMetaData) {
        super.setVehicleMetaData(vehicleMetaData);
    }
}
