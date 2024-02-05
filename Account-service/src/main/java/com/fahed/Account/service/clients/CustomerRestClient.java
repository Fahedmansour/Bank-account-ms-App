package com.fahed.Account.service.clients;

import com.fahed.Account.service.models.Customer;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
@FeignClient(name = "CUSTOMER-SERVICE")
public interface CustomerRestClient {
    @CircuitBreaker(name = "customerService",fallbackMethod = "getDefaultCustomer")
    @GetMapping("/customers/{id}")
    Customer findCustomerById(@PathVariable Long id);
    @CircuitBreaker(name = "customerService",fallbackMethod = "getAllCustomer")
    @GetMapping("/customers")
    List<Customer> allCustomers();

    default Customer getDefaultCustomer(Long id,Exception exception) {
        Customer customer=new Customer();
        customer.setId(id);
        customer.setFirstName("not available");
        customer.setLastName("not available");
        customer.setEmail("not available");
        return customer;
    }

    default List<Customer> getAllCustomer(Exception exception){
        return List.of();
    }

}
