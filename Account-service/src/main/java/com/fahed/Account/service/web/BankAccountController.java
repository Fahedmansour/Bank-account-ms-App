package com.fahed.Account.service.web;

import com.fahed.Account.service.Repositorys.BankAccountRepository;
import com.fahed.Account.service.clients.CustomerRestClient;
import com.fahed.Account.service.entities.BankAccount;
import com.fahed.Account.service.models.Customer;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BankAccountController {
    private BankAccountRepository bankAccountRepository;
    private CustomerRestClient customerRestClient;

    public BankAccountController(BankAccountRepository bankAccountRepository, CustomerRestClient customerRestClient) {
        this.bankAccountRepository = bankAccountRepository;
        this.customerRestClient = customerRestClient;
    }

    @GetMapping("/accounts")

    public List<BankAccount> accountList(){
        return bankAccountRepository.findAll();
    }
    @GetMapping("/accounts/{id}")
    public  BankAccount bankAccountById(@PathVariable  String id){
        BankAccount bankAccount=bankAccountRepository.findById(id).get();
        Customer customer=customerRestClient.findCustomerById(bankAccount.getCustomerId());
        bankAccount.setCustomer(customer);
        return bankAccount;

    }



}
