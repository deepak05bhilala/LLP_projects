package com.example.RishiTraders.InventroyManagementSystem;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Product {
    @EqualsAndHashCode.Include
    private Integer id;
    private String name;
    private Double price;
    private Integer quantity;
}
