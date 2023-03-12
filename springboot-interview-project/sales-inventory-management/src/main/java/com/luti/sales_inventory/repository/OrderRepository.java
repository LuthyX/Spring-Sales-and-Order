package com.luti.sales_inventory.repository;

import com.luti.sales_inventory.model.WebOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<WebOrder, Long> {
}
