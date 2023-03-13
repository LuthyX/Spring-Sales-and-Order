package com.luti.sales_inventory;

import com.luti.sales_inventory.request.CreateCustomerRequest;
import com.luti.sales_inventory.request.CreateProductRequest;
import com.luti.sales_inventory.service.CustomerService;
import com.luti.sales_inventory.service.ProductService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringSalesInventory {
    public static void main(String[] args) {
        SpringApplication.run(SpringSalesInventory.class);
    }
    @Bean
    CommandLineRunner run(CustomerService customerService, ProductService productService) {
        return args -> {
            customerService.createCustomer(new CreateCustomerRequest("John", "08104057"));
            customerService.createCustomer(new CreateCustomerRequest("Job", "081040689"));
            productService.addProduct(new CreateProductRequest("Game1", "Very nice game",10, 4.5));
            productService.addProduct(new CreateProductRequest("Game2", "Very nice game",5, 4.5));
        };

    }
}
