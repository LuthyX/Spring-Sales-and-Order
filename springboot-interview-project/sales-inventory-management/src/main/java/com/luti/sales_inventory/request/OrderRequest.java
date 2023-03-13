package com.luti.sales_inventory.request;

import lombok.Data;

@Data
public class OrderRequest {
    private Long customer_id;
    private Long product_id;
    private Integer quantity;
}

