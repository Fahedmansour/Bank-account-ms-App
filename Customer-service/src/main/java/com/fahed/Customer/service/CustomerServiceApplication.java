package com.fahed.Customer.service;

import com.fahed.Customer.service.config.GlobalConfig;
import com.fahed.Customer.service.entities.Customer;
import com.fahed.Customer.service.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
@EnableConfigurationProperties(GlobalConfig.class)
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(CustomerRepository customerRepository){
		return args -> {

			List<Customer> customerList=List.of(
					Customer.builder()
							.firstName("Fahed")
							.lastName("mansour")
							.email("fahed@gamil.com")
							.build(),
					Customer.builder()
							.firstName("sabah")
							.lastName("mansour")
							.email("*sabah@gamil.com")
							.build()

			);
			customerRepository.saveAll(customerList);
		};
	}

}
