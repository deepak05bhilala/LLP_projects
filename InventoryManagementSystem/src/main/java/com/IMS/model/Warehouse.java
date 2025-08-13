package com.IMS.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import com.example.RishiTraders.InventoryManagementSystem.main.java.com.IMS.model.Inventory;
@Data
@AllArgsConstructor
public class Warehouse {
    private String id;
    private String name;
    private Inventory inventory;
}
