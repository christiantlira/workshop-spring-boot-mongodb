package com.christorres.workshopmongo.repository;

import java.io.Serializable;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.christorres.workshopmongo.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

}
