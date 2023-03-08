package com.christorres.workshopmongo.resources;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.christorres.workshopmongo.domain.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@GetMapping
	public ResponseEntity<List<User>> findAll() {
		User maria = new User("1", "Maria Silva", "maria@gmail.com");
		User alex = new User("2", "Alex Ryco", "alex@gmail.com");
		User bob = new User("3", "Bob Tabor", "bob@gmail.com");
		List<User> list = Arrays.asList(maria, alex, bob);
		// List<User> list = new ArrayList<>();
		// list.addAll(Arrays.asList(maria, alex, bob));
		// EM CASO DE ERRO IMPLEMENTAR ASSIM ^^^^
		return ResponseEntity.ok().body(list);
	}

}
