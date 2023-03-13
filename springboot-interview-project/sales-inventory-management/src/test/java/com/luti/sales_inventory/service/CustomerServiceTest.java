package com.luti.sales_inventory.service;

import com.luti.sales_inventory.exception.CustomerAlreadyExistsException;
import com.luti.sales_inventory.request.CreateCustomerRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
public class CustomerServiceTest {
    @Autowired
    private CustomerService customerService;

    @Test
    @Transactional
    public void testCreateCustomer(){
        CreateCustomerRequest customer = new CreateCustomerRequest("Kol", "0819876");
        Assertions.assertThrows(CustomerAlreadyExistsException.class, ()->customerService.createCustomer(customer),"Customer already exist");
        customer.setName("Milner");
        Assertions.assertDoesNotThrow(()-> customerService.createCustomer(customer), "Customer Registered Successfully!");
    }
}
