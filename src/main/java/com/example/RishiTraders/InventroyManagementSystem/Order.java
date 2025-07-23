package com.example.RishiTraders.InventroyManagementSystem;

import com.example.RishiTraders.InventroyManagementSystem.Enum.OrderStatusEnum;
import lombok.Data;
import java.util.Map;

@Data
public class Order {
    private Integer orderId;
    private Invoice invoice;
    private Payment payment;
    Map<Integer,Integer> productCategoryIdVsQuantity;
    Address address;
    Warehouse warehouse;
    User user;
    OrderStatusEnum orderStatusEnum;
}
