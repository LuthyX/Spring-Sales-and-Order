package com.luti.sales_inventory.request;

import lombok.Data;

@Data
public class UpdateProductRequest {
    private String name;
    private String description;
    private Integer quantity;
    private Double price;
}
