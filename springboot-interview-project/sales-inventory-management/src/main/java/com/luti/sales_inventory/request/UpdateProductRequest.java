package com.luti.sales_inventory.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateProductRequest {
    private String name;
    private String description;
    private Integer quantity;
    private Double price;
}
