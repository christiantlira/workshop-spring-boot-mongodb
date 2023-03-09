package com.christorres.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.christorres.workshopmongo.domain.Post;
import com.christorres.workshopmongo.domain.User;
import com.christorres.workshopmongo.dto.AuthorDTO;
import com.christorres.workshopmongo.repository.PostRepository;
import com.christorres.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;

	@Override
	public void run(String... args) throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User gilo = new User(null, "Gilozinho Delash", "gilozinho@gmail.com");
		User alex = new User(null, "Alex Ryco", "alex@gmail.com");
		User bob = new User(null, "Bob Tabor", "bob@gmail.com");
		
		userRepository.saveAll(Arrays.asList(gilo, alex, bob));
		
		Post post1 = new Post(null, sdf.parse("21/03/2023"), "Partiu viagem", "Vou viajar para São Paulo. Abraços!", new AuthorDTO(gilo));
		Post post2 = new Post(null, sdf.parse("23/03/2023"), "Bom dia", "Acordei feliz hoje!", new AuthorDTO(gilo));
		
		
		postRepository.saveAll(Arrays.asList(post1, post2));
		
		gilo.getPosts().addAll(Arrays.asList(post1, post2));
		userRepository.save(gilo);
	}

}
