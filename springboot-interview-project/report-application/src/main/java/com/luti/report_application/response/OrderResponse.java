package com.luti.report_application.response;

import lombok.Data;

@Data
public class OrderResponse {
    private Boolean success;
    private String Date;
    private Double Total_Order_Amount = 0.0;
    private Integer Total_Order;
}
