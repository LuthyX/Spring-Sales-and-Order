package com.luti.report_application.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class KafkaOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long customer_id;
    private Long product_id;
    private Double amount;
    private Integer quantity;
    private LocalDate date;

    @Override
    public String toString() {
        return "KafOrder{" +
                "id=" + id +
                ", customer_id=" + customer_id +
                ", product_id=" + product_id +
                ", total_amount=" + amount +
                ", quantity=" + quantity +
                ", date=" + date +
                '}';
    }
}
