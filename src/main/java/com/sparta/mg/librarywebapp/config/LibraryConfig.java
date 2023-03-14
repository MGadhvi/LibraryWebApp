package com.sparta.mg.librarywebapp.config;

import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@EnableWebMvc
@EnableWebSecurity
@EnableMethodSecurity
public class LibraryConfig {


}
