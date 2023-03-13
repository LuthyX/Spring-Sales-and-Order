package com.luti.sales_inventory.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateProductRequest {
    private String name;
    private String description;
    private Integer quantity;
    private Double price;
}