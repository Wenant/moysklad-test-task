package ru.biryukov.model;

import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    private int id;
    private String name;
    private String description;
    private BigDecimal price = new BigDecimal("0.0");
    private boolean available = false;

}