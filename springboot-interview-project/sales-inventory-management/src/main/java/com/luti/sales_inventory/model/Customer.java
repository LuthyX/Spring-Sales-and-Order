package com.luti.sales_inventory.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String phonenumber;

//    @JsonIgnore
//    @OneToMany(mappedBy = "customer")
//    private List<WebOrder> orders = new ArrayList<>();
}
