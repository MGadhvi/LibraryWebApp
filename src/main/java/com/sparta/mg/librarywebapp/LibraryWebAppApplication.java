package com.sparta.mg.librarywebapp;

import com.sparta.mg.librarywebapp.model.entities.User;
import com.sparta.mg.librarywebapp.model.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class LibraryWebAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(LibraryWebAppApplication.class, args);
    }

//    @Bean
//    CommandLineRunner runner(UserRepository userRepository, PasswordEncoder passwordEncoder) {
//        return args -> {
//            userRepository.save(new User("user", passwordEncoder.encode("password"), "ROLE_USER"));
//            userRepository.save(new User("admin", passwordEncoder.encode("password"), "ROLE_USER,ROLE_ADMIN"));
//        };
//    }
}
