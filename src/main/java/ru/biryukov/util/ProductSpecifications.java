package ru.biryukov.util;

import org.springframework.data.jpa.domain.Specification;
import ru.biryukov.model.Product;

public class ProductSpecifications {
    public static Specification<Product> withName(String name) {
        return (root, query, builder) -> builder.like(root.get("name"), "%" + name + "%");
    }

    public static Specification<Product> withPriceBetween(Double minPrice, Double maxPrice) {
        return (root, query, builder) -> builder.between(root.get("price"), minPrice, maxPrice);
    }

    public static Specification<Product> withMinPrice(Double minPrice) {
        return (root, query, builder) -> builder.greaterThanOrEqualTo(root.get("price"), minPrice);
    }

    public static Specification<Product> withMaxPrice(Double maxPrice) {
        return (root, query, builder) -> builder.lessThanOrEqualTo(root.get("price"), maxPrice);
    }

    public static Specification<Product> available(Boolean available) {
        return (root, query, builder) -> builder.equal(root.get("available"), available);
    }
}

