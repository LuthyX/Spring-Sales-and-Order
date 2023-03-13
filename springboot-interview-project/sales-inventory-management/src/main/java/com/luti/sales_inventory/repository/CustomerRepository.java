package com.luti.sales_inventory.repository;

import com.luti.sales_inventory.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

   Optional<Customer> findByName(String name);
}
