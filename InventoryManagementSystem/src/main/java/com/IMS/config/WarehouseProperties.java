package com.example.RishiTraders.InventoryManagementSystem.main.java.com.IMS.config;

import com.example.RishiTraders.InventoryManagementSystem.main.java.com.IMS.model.WarehouseDescriptor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@ConfigurationProperties(prefix="inventory")

public class WarehouseProperties {
    List<WarehouseDescriptor> warehouseDescriptorList;
}
