package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}

@RestController
@RequestMapping("/api")
class ExampleController {

	@GetMapping("/example")
	public String getExample() {
		return "Este é um endpoint de exemplo!";
	}

	@RestController
	@RequestMapping("/api")
	class UserController {

		@GetMapping("/users")
		public List<User> getUsers() {
			return Arrays.asList(
					new User(1, "João", "joao@example.com"),
					new User(2, "Maria", "maria@example.com"),
					new User(3, "Carlos", "carlos@example.com")
			);
		}
	}

	class User {
		private int id;
		private String name;
		private String email;

		public User(int id, String name, String email) {
			this.id = id;
			this.name = name;
			this.email = email;
		}

		// Getters
		public int getId() {
			return id;
		}

		public String getName() {
			return name;
		}

		public String getEmail() {
			return email;
		}
	}

}
