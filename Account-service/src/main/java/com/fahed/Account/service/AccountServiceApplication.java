package com.fahed.Account.service;

import com.fahed.Account.service.Repositorys.BankAccountRepository;
import com.fahed.Account.service.clients.CustomerRestClient;
import com.fahed.Account.service.entities.BankAccount;
import com.fahed.Account.service.enums.AccountType;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.UUID;

@SpringBootApplication
@EnableFeignClients
public class AccountServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountServiceApplication.class, args);
	}
@Bean
	CommandLineRunner commandLineRunner(BankAccountRepository bankAccountRepository, CustomerRestClient customerRestClient){
		return args -> {
/*

			BankAccount bankAccount1=BankAccount.builder()
					.accountId(UUID.randomUUID().toString())
					.currency("DNT")
					.balance(Math.random()*3000)
					.createAt(LocalDate.now())
					.type(AccountType.CURRANT_ACCOUNT)
					.customerId(Long.valueOf(1))
					.build();
			BankAccount bankAccount2=BankAccount.builder()
					.accountId(UUID.randomUUID().toString())
					.currency("DNT")
					.balance(Math.random()*5000)
					.createAt(LocalDate.now())
					.type(AccountType.SAVING_ACCOUNT)
					.customerId(Long.valueOf(2))
					.build();

			bankAccountRepository.save(bankAccount1);
			bankAccountRepository.save(bankAccount2);
*/


			customerRestClient.allCustomers().forEach(c->{
				BankAccount bankAccount1=BankAccount.builder()
						.accountId(UUID.randomUUID().toString())
						.currency("DNT")
						.balance(Math.random()*3000)
						.createAt(LocalDate.now())
						.type(AccountType.CURRANT_ACCOUNT)
						.customerId(c.getId())
						.build();
				BankAccount bankAccount2=BankAccount.builder()
						.accountId(UUID.randomUUID().toString())
						.currency("DNT")
						.balance(Math.random()*5000)
						.createAt(LocalDate.now())
						.type(AccountType.SAVING_ACCOUNT)
						.customerId(c.getId())
						.build();

				bankAccountRepository.save(bankAccount1);
				bankAccountRepository.save(bankAccount2);

			});


		};
	}
}
