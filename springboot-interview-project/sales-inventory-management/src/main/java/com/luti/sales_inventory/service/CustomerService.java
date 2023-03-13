package com.luti.sales_inventory.service;

import com.luti.sales_inventory.exception.CustomerAlreadyExistsException;
import com.luti.sales_inventory.model.Customer;
import com.luti.sales_inventory.repository.CustomerRepository;
import com.luti.sales_inventory.request.CreateCustomerRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    private CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer createCustomer(CreateCustomerRequest request) throws CustomerAlreadyExistsException {
        Customer customer = new Customer();
        if(
                customerRepository.findByName(request.getName()).isPresent()
        ){
          throw new CustomerAlreadyExistsException();
        }

        customer.setName(request.getName());
        customer.setPhonenumber(request.getPhonenumber());
        customerRepository.save(customer);
        return customer;
    }
    public List<Customer> getCustomers(){
        return customerRepository.findAll();
    }
}
