package ru.biryukov.repository;

import org.springframework.stereotype.Repository;
import ru.biryukov.model.Product;

import java.util.List;

@Repository
public interface ProductRepository {

    void addProduct(Product product);

    List<Product> getAllProducts();

    Product getProductById(int id);

    void updateProduct(int id, Product product);

    void deleteProductById(int id);

}