package ru.biryukov;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ru.biryukov.model.Product;
import ru.biryukov.repository.ProductRepository;

import java.math.BigDecimal;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public ApplicationRunner initializeProducts(ProductRepository productRepository) {
        return args -> {
            BigDecimal price = new BigDecimal("1.0");
            Product productOne = new Product(0, "productOne", "description 1", price, true);
            Product productTwo = new Product(0, "productTwo", "description 2", price, false);
            Product productThree = new Product(0, "productThree", "description 3", price, true);

            productRepository.addProduct(productOne);
            productRepository.addProduct(productTwo);
            productRepository.addProduct(productThree);
        };
    }
}