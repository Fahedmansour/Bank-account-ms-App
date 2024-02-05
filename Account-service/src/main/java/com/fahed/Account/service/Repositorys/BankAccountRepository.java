package com.fahed.Account.service.Repositorys;

import com.fahed.Account.service.entities.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankAccountRepository extends JpaRepository<BankAccount,String> {
}
