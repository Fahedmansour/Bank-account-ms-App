package com.fahed.Customer.service.repository;

import com.fahed.Customer.service.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
