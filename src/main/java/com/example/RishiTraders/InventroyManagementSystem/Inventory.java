package com.example.RishiTraders.InventroyManagementSystem;

import lombok.Data;

import java.util.List;

@Data
public class Inventory {
    //TODO : I dont think we should use List DS, as productCategory could have large count
    //TODO: I also think we need a higher level abstraction above product category
    // for example Inventory->{Biscuit,Brush,Milk...}->{GoodDay,ParleG....}->{GoodDayProductList,ParleGProductList}
    List<ProductCategory> productCategoryList;
}
