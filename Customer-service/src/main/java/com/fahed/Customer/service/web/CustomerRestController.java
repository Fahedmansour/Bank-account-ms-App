package com.fahed.Customer.service.web;

import com.fahed.Customer.service.entities.Customer;
import com.fahed.Customer.service.repository.CustomerRepository;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class CustomerRestController {

    private CustomerRepository customerRepository;
    public CustomerRestController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @GetMapping("/customers")
   private List<Customer> customerList(){
        return customerRepository.findAll();
   }

    @GetMapping("/customers/{id}")
   private  Customer customerById(@PathVariable Long id){
        return customerRepository.findById(id).get();
   }


}
