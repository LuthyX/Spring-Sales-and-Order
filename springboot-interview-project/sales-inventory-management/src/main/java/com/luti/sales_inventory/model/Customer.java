package com.luti.sales_inventory.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String phonenumber;

    @JsonIgnore
    @OneToMany(mappedBy = "customer")
    private List<WebOrder> orders = new ArrayList<>();
}
