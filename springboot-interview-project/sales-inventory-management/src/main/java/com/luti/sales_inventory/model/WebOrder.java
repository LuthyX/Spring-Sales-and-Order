package com.luti.sales_inventory.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WebOrder {
    private Long customer_id;
    private Long product_id;
    private Double amount;
    private Integer quantity;
    private LocalDate date;

    @Override
    public String toString() {
        return "WebOrder{" +
                "customer_id=" + customer_id +
                ", product_id=" + product_id +
                ", amount=" + amount +
                ", quantity=" + quantity +
                ", date=" + date +
                '}';
    }
}
