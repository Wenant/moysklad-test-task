package ru.biryukov.repository.impl;

import org.springframework.stereotype.Repository;
import ru.biryukov.exception.ProductNotFoundException;
import ru.biryukov.model.Product;
import ru.biryukov.repository.ProductRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepositoryImpl implements ProductRepository {
    private final List<Product> products = new ArrayList<>();
    private final BigDecimal price = new BigDecimal("1.0");
    Product productOne = new Product("productOne", "description 1", price , true);
    Product productTwo = new Product("productTwo", "description 2", price , false);
    Product productThree = new Product("productThree", "description 3", price , true);

    public ProductRepositoryImpl() {
        products.add(productOne);
        products.add(productTwo);
        products.add(productThree);
    }



    @Override
    public void addProduct(Product product) {
        products.add(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return products;
    }

    @Override
    public Product getProductById(int id) {
        if (id < 0 || id >= products.size()) {
            throw new ProductNotFoundException("Product with id " + id + " not found");
        }
        return products.get(id);
    }

    @Override
    public void updateProduct(int id, Product product) {
        products.add(id, product);
    }

    @Override
    public void deleteProductById(int id) {
        products.remove(id);

    }
}
