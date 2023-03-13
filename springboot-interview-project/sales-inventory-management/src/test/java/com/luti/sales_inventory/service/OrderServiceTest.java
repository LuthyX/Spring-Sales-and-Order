package com.luti.sales_inventory.service;

import com.luti.sales_inventory.exception.CustomerDoesNotExistException;
import com.luti.sales_inventory.exception.ProductDoesNotExistException;
import com.luti.sales_inventory.request.OrderRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
public class OrderServiceTest {

    @Autowired
    private OrderService orderService;


    @Test
    @Transactional
    public void testMakeOrder(){
        OrderRequest order = new OrderRequest(48L, 1L, 4);
        Assertions.assertThrows(CustomerDoesNotExistException.class, ()->orderService.makeOrder(order),"Customer id does not exist");
        order.setCustomer_id(1L);
        order.setProduct_id(48L);
        Assertions.assertThrows(ProductDoesNotExistException.class, ()->orderService.makeOrder(order), "Product id does not exist");
        order.setProduct_id(1L);
        Assertions.assertDoesNotThrow(()-> orderService.makeOrder(order), "Order Made Successfully!");
    }
}
