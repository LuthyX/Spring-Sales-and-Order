package com.luti.sales_inventory.controllers;

import com.luti.sales_inventory.exception.CustomerAlreadyExistsException;
import com.luti.sales_inventory.model.Customer;
import com.luti.sales_inventory.request.CreateCustomerRequest;
import com.luti.sales_inventory.response.BaseResponse;
import com.luti.sales_inventory.response.ListResponse;
import com.luti.sales_inventory.service.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {
    private final static String CUSTOMER_CREATED = "Customer successfully created";
    private final static String CUSTOMER_ALREADY_EXISTS = "Customer Already exists, try another name";

    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping()
    private ResponseEntity<ListResponse> getCustomers(){
        ListResponse response = new ListResponse();
        List<Customer> customers = customerService.getCustomers();
        response.setSuccess(true);
        response.setData(customers);
        return ResponseEntity.status(200).body(response);
    }
    private ResponseEntity<BaseResponse> createCustomer(@RequestBody CreateCustomerRequest request){
        BaseResponse response = new BaseResponse();
        try{
            Customer customer = customerService.createCustomer(request);
            response.setSuccess(true);
            response.setData(customer);
            response.setMsg(CUSTOMER_CREATED);
            return ResponseEntity.status(201).body(response);
        }
        catch (CustomerAlreadyExistsException e){
            response.setSuccess(false);
            response.setMsg(CUSTOMER_ALREADY_EXISTS);
            return ResponseEntity.status(409).body(response);
        }
    }
}
