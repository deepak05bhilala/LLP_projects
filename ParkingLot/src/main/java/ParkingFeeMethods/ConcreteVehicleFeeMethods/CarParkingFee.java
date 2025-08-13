package com.example.RishiTraders.ParkingLot.ParkingFeeMethods.ConcreteVehicleFeeMethods;

import com.example.RishiTraders.ParkingLot.ParkingFeeMethods.ParkingFeeInterface;

import java.util.Date;

public class CarParkingFee implements ParkingFeeInterface {

    @Override
    public Integer calculateFee(Date startDateTime, Date endDateTime) {
        return 100;
    }
}
