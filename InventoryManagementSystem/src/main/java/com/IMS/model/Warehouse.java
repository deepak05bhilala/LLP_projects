package com.example.RishiTraders.InventoryManagementSystem.main.java.com.IMS.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Warehouse {
    private String id;
    private String name;
    private Inventory inventory;
}
