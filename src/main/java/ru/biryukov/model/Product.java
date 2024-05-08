package ru.biryukov.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "products")
public class Product {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", length = 255, nullable = false)
    private String name;

    @Column(name = "description", length = 4096)
    private String description;

    @Column(name = "price")
    @Min(0)
    @Digits(integer = 10, fraction = 2)
    private BigDecimal price;

    @Column(nullable = false)
    private boolean available = false;

}