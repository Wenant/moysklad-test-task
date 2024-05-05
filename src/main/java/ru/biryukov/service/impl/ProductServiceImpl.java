package ru.biryukov.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.biryukov.model.Product;
import ru.biryukov.repository.ProductRepository;
import ru.biryukov.service.ProductService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;


    @Override
    public void addProduct(Product product) {
        productRepository.addProduct(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.getAllProducts();
    }

    @Override
    public Product getProductById(int id) {
        return productRepository.getProductById(id);
    }

    @Override
    public void updateProduct(int id, Product product) {
        productRepository.updateProduct(id,product);
    }

    @Override
    public void deleteProductById(int id) {
        productRepository.deleteProductById(id);

    }
}