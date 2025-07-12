package com.example.RishiTraders.InventroyManagementSystem;

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
}
