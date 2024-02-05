package com.fahed.Account.service.entities;

import com.fahed.Account.service.enums.AccountType;
import com.fahed.Account.service.models.Customer;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
@Entity
@Getter  @Setter @AllArgsConstructor @NoArgsConstructor @Builder @ToString
public class BankAccount {
@Id
    private String accountId;
    private double balance;
    private LocalDate createAt;
    private String currency;
    @Enumerated(EnumType.STRING)
    private AccountType type;
    @Transient
    private Customer customer;
    private Long customerId;


}
