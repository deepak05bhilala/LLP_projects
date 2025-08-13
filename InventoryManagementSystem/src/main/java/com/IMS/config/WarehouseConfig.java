package com.IMS.config;


import com.IMS.factory.InventoryFactory;
import com.IMS.model.Warehouse;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.List;

@Configuration
@AllArgsConstructor
public class WarehouseConfig {
    private final WarehouseProperties warehouseProperties;
    private final InventoryFactory inventoryFactory;

    @Bean
    public List<Warehouse> warehouses(){
        return warehouseProperties.getWarehouseDescriptorList().stream()
                .map(d -> new Warehouse(
                        d.getId(),
                        d.getName(),
                        inventoryFactory.buildFor(d.getId())
                ))
                .toList();
    }
}
