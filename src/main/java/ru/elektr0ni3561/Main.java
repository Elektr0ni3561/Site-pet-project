package ru.elektr0ni3561;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("ru.elektr0ni3561")
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}