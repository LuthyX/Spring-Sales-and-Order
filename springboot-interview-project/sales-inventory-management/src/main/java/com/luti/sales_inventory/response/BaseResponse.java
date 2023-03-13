package com.luti.sales_inventory.response;

import lombok.Data;

@Data
public class BaseResponse {
    private Boolean success;
    private String msg;
    private Object data;
}
