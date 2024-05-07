package ru.biryukov.repository.impl;

import org.springframework.stereotype.Repository;
import ru.biryukov.exception.ProductNotFoundException;
import ru.biryukov.model.Product;
import ru.biryukov.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepositoryImpl implements ProductRepository {
    private final List<Product> products = new ArrayList<>();

    @Override
    public void addProduct(Product product) {
        product.setId(products.size());
        products.add(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return products;
    }

    @Override
    public Product getProductById(int id) {
        validateProductId(id);
        return products.get(id);
    }

    @Override
    public void updateProduct(int id, Product product) {
        validateProductId(id);
        products.set(id, product);
    }

    @Override
    public void deleteProductById(int id) {
        validateProductId(id);
        products.remove(id);

        // Update the id of the remaining products
        for (int i = id; i < products.size(); i++) {
            products.get(i).setId(i);
        }

    }

    private void validateProductId(int id) {
        if (id < 0 || id >= products.size()) {
            throw new ProductNotFoundException("Product with id " + id + " not found");
        }
    }
}
