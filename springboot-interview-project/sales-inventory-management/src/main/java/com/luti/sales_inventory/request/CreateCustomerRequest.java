package com.luti.sales_inventory.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class CreateCustomerRequest {
    private String name;
    private String phonenumber;
}