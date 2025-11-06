package com.example.parta;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public Course course() {
        return new Course("Spring Framework");
    }

    @Bean
    public Student student() {
        Student s = new Student();
        s.setName("Nansi Kumari");
        s.setCourse(course());
        return s;
    }
}
