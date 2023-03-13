package com.luti.sales_inventory.response;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ListResponse {
    private Boolean success = false;
    private List<?> data = new ArrayList<>();
}
