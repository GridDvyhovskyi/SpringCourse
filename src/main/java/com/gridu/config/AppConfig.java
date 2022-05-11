package com.gridu.config;

import com.gridu.repository.InMemoryRepository;
import com.gridu.repository.InMemoryRepositoryImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.*;

@Configuration
@EnableWebMvc
@ComponentScan({"com.gridu"})
public class AppConfig {

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    public Map<String, Set<String>> defaultData() {
        Map<String, Set<String>> data = new LinkedHashMap<>();
        data.put("Alex", Set.of("+79601232233"));
        data.put("Billy", Set.of("+79213215566", "+79213215567", "+79213215568"));
        return data;
    }

    @Bean(name = "repository")
    public InMemoryRepository inMemoryRepository(Map<String, Set<String>> defaultData) {
        return new InMemoryRepositoryImpl(defaultData);
    }
}
