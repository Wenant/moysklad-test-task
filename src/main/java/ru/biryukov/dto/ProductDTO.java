package ru.biryukov.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class ProductDTO {
    private String name;
    private String description;
    private BigDecimal price;
    private boolean available = false;
}