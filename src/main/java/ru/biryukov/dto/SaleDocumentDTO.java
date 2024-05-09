package ru.biryukov.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class SaleDocumentDTO {


    private Long id;

    private Long productId;

    @NotEmpty(message = "Name cannot be empty")
    @Size(max = 255, message = "Sale Document name must be no more than 255 characters")
    private String name;

    @Positive(message = "Quantity cannot be negative")
    private int quantity;


    private BigDecimal totalCost;


}