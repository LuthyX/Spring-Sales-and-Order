package com.luti.sales_inventory.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequest {
    private Long customer_id;
    private Long product_id;
    private Integer quantity;
}

