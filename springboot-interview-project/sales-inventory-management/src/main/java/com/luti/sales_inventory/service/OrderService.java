package com.luti.sales_inventory.service;

import com.luti.sales_inventory.exception.CustomerDoesNotExistException;
import com.luti.sales_inventory.exception.OutOfStockException;
import com.luti.sales_inventory.exception.ProductDoesNotExistException;
import com.luti.sales_inventory.kafka.KafkaProducer;
import com.luti.sales_inventory.model.Customer;
import com.luti.sales_inventory.model.Product;
import com.luti.sales_inventory.model.WebOrder;
import com.luti.sales_inventory.repository.CustomerRepository;
import com.luti.sales_inventory.repository.ProductRepository;
import com.luti.sales_inventory.request.OrderRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@Slf4j
public class OrderService {
    private CustomerRepository customerRepository;
    private ProductRepository productRepository;
    private KafkaProducer kafkaProducer;


    public OrderService( CustomerRepository customerRepository, ProductRepository productRepository, KafkaProducer kafkaProducer) {
        this.customerRepository = customerRepository;
        this.productRepository = productRepository;
        this.kafkaProducer = kafkaProducer;
    }

    public WebOrder makeOrder(OrderRequest request) throws CustomerDoesNotExistException, ProductDoesNotExistException, OutOfStockException {
        Customer customer = customerRepository.findById(request.getCustomer_id()).orElseThrow(CustomerDoesNotExistException::new);
        Product product = productRepository.findById(request.getProduct_id()).orElseThrow(ProductDoesNotExistException::new);
        if(request.getQuantity() > product.getInStock()) {
            throw new OutOfStockException();
        }
        product.setInStock(product.getInStock() - request.getQuantity());
        productRepository.save(product);
        WebOrder order = new WebOrder(customer.getId(), product.getId(), (product.getPrice()*request.getQuantity()), request.getQuantity(), LocalDate.now());
        kafkaProducer.sendMessage(order);
        return order;
    }
}
