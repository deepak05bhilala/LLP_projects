package com.IMS.config;


import com.IMS.model.WarehouseDescriptor;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Component
@ConfigurationProperties(prefix="inventory")
public class WarehouseProperties {
    List<WarehouseDescriptor> warehouseDescriptorList;
}
