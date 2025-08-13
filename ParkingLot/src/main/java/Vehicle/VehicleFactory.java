package com.example.RishiTraders.ParkingLot.Vehicle;

import com.example.RishiTraders.ParkingLot.Vehicle.ConcreteVehicles.Bike;
import com.example.RishiTraders.ParkingLot.Vehicle.ConcreteVehicles.Car;
import com.example.RishiTraders.ParkingLot.Vehicle.ConcreteVehicles.Truck;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class VehicleFactory {
    private static final Map<String, Function<VehicleMetaData, Vehicle>> registry = new HashMap<>();

    static {
        registry.put("car", Car::new);
        registry.put("bike", Bike::new);
        registry.put("truck", Truck::new);
    }

    public static void register(String type, Function<VehicleMetaData, Vehicle> constructor) {
        registry.put(type.toLowerCase(), constructor);
    }

    public static Vehicle getVehicle(String type, VehicleMetaData metadata) {
        Function<VehicleMetaData, Vehicle> constructor = registry.get(type.toLowerCase());
        if (constructor == null)
            throw new IllegalArgumentException("Unknown vehicle type: " + type);
        return constructor.apply(metadata);
    }
}

