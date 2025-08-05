package com.example.RishiTraders.BookMyShow.Enum;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
@AllArgsConstructor
public enum City {
    BANGALORE("BLR","Banglore"),
    MUMBAI("BOM","Mumbai");

    private final String code;
    private final String name;

    private static final Map<String,City> BY_CODE = new HashMap<>();
    static {
        for(City city: values()){
            BY_CODE.put(city.code,city);
        }
    }

    public static City fromCode(String name){
        City result = BY_CODE.get(name);
        if(result!=null){
            return result;
        }
        throw new IllegalArgumentException("Invalid City Code: "+ name);
    }
}
