package com.example.RishiTraders.InventroyManagementSystem;

import lombok.Data;

import java.util.List;
@Data
public class ProductCategory {
    private Integer categoryId;
    private String categoryName;
    private List<Product> productList;

    public void addProductToCategory(Product productToAdd){
        productList.add(productToAdd);
    }
    public Boolean removeProductFromCategory(Product productToRemove){

    }
}


// https://chatgpt.com/share/6871c6d4-d4d0-8007-95ba-24df8054ff92
