package ru.biryukov.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class ProductFilterDTO {

    @PositiveOrZero(message = "Page number cannot be negative")
    private int page = 0;

    @Min(value = 1, message = "Page size must be greater than or equal to 1")
    private int size = 10;

    @Pattern(regexp = "price|name", message = "sortBy must be 'price' or 'name'")
    private String sortBy;

    @Pattern(regexp = "asc|desc", message = "sortDirection must be 'asc' or 'desc'")
    private String sortDirection;

    @Size(max = 255, message = "Product name must be no more than 255 characters")
    private String name;

    @PositiveOrZero(message = "Min price cannot be negative")
    private Double minPrice;

    @PositiveOrZero(message = "Max price cannot be negative")
    private Double maxPrice;

    private Boolean available;
}
