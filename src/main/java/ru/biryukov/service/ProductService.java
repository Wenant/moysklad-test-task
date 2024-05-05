package ru.biryukov.service;

import ru.biryukov.model.Product;

import java.util.List;

public interface ProductService {
    void addProduct(Product product);
    List<Product> getAllProducts();
    Product getProductById(int id);

    void updateProduct(int id,Product product);

    void deleteProductById(int id);
}
