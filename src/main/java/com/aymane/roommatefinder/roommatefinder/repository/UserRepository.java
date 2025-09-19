package com.aymane.roommatefinder.roommatefinder.repository;

import com.aymane.roommatefinder.roommatefinder.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {

    Optional<User> findByEmail(String email);

}