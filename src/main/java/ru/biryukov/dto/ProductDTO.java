package ru.biryukov.dto;


import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class ProductDTO {

    private int id;

    @NotBlank(message = "Название не может быть пустым")
    @Size(max = 255, message = "Название товара должно содержать не более 255 символов")
    private String name;

    @Size(max = 4096, message = "Описание товара должно содержать не более 4096 символов")
    private String description;

    @PositiveOrZero(message = "Цена товара не может быть отрицательной")
    private BigDecimal price = new BigDecimal("0.0");


    private boolean available = false;
}