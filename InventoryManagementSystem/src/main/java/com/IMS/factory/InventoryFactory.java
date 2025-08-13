package com.IMS.factory;

import com.example.RishiTraders.InventoryManagementSystem.main.java.com.IMS.model.Inventory;
public interface InventoryFactory {
    Inventory buildFor(String warehouseId);
}
