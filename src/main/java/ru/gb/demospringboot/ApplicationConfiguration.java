package ru.gb.demospringboot;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// java-based configuration
//@Configuration
public class ApplicationConfiguration {
    @Bean
    public StudentRepository studentRepository(){
        return new StudentRepository();
    }
}
