package com.example.RishiTraders.InventroyManagementSystem;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Address {
    private Integer pinCode;
    private String landmark;
    private String area_road;
}
