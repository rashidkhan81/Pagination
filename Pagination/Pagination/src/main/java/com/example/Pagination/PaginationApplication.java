package com.example.Pagination;

import com.example.Pagination.entity.User;
import com.example.Pagination.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PaginationApplication implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(PaginationApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		// Add some dummy data for testing
		for (int i = 1; i <= 7; i++) {
			userRepository.save(new User(null, "User " + i, "user" + i + "@example.com"));
		}
	}
}
