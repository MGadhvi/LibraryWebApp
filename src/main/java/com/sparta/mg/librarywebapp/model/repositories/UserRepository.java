package com.sparta.mg.librarywebapp.model.repositories;

import com.sparta.mg.librarywebapp.model.entities.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User,Long> {
    Optional<User> findByUserName(String username);

}
