package ru.biryukov.dto;


import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class ProductDTO {

    private Long id;

    @NotEmpty(message = "Name cannot be empty")
    @Size(max = 255, message = "Product name must be no more than 255 characters")
    private String name;

    @Size(max = 4096, message = "Product description must be no more than 4096 characters")
    private String description = "";

    @PositiveOrZero(message = "Product price cannot be negative")
    @Digits(integer = 10, fraction = 2, message = "Price must have at most {integer} digits and {fraction} decimal places.")
    private BigDecimal price = new BigDecimal("0.0");

    private boolean available = false;

}