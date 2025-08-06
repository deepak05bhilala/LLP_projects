package com.IMS.factory;

import com.example.RishiTraders.InventoryManagementSystem.main.java.com.IMS.model.Inventory;

public class DefaultInventoryFactory implements  InventoryFactory{
    @Override
    public Inventory buildFor(String warehouseId) {
        return  new Inventory();
    }
}
