package com.christorres.workshopmongo.config;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.christorres.workshopmongo.domain.User;
import com.christorres.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {

		userRepository.deleteAll();
		User maria = new User(null, "Maria Godoy", "maria@gmail.com");
		User alex = new User(null, "Alex Ryco", "alex@gmail.com");
		User bob = new User(null, "Bob Tabor", "bob@gmail.com");
		
		userRepository.saveAll(Arrays.asList(maria, alex, bob));

	}

}
