package ru.biryukov.util;

import org.springframework.data.jpa.domain.Specification;
import ru.biryukov.model.Product;

public class ProductSpecificationBuilder {
    public static Specification<Product> buildSpecification(String name, Double minPrice, Double maxPrice, Boolean available) {
        Specification<Product> spec = Specification.where(null);

        if (name != null) {
            spec = spec.and(ProductSpecifications.withName(name));
        }
        if (minPrice != null && maxPrice != null) {
            spec = spec.and(ProductSpecifications.withPriceBetween(minPrice, maxPrice));
        } else {
            if (minPrice != null) {
                spec = spec.and(ProductSpecifications.withMinPrice(minPrice));
            }
            if (maxPrice != null) {
                spec = spec.and(ProductSpecifications.withMaxPrice(maxPrice));
            }
        }
        if (available != null) {
            spec = spec.and(ProductSpecifications.available(available));
        }

        return spec;
    }
}

