package ru.biryukov.repository;

import ru.biryukov.model.Product;

import java.util.List;

public interface ProductRepository {

    void addProduct(Product product);

    List<Product> getAllProducts();

    Product getProductById(int id);

    void updateProduct(int id, Product product);

    void deleteProductById(int id);

}
