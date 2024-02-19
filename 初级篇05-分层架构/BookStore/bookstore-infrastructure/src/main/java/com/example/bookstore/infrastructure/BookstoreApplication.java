package com.example.bookstore.infrastructure;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EntityScan("com.example.bookstore.domain")  // 指定JPA实体类扫描的根包路径
@ComponentScan(basePackages = {"com.example.bookstore"})
public class BookstoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookstoreApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner() {
        return args -> {
            System.out.println("Swagger UI: http://localhost:8080/swagger-ui/index.html");
            System.out.println("H2 Console: http://localhost:8080/h2-console");
        };
    }
}
