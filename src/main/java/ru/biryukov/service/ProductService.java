package ru.biryukov.service;

import org.springframework.stereotype.Service;
import ru.biryukov.dto.ProductDTO;

import java.util.List;

@Service
public interface ProductService {
    void addProduct(ProductDTO product);

    List<ProductDTO> getAllProducts();

    ProductDTO getProductById(Long id);

    void updateProduct(Long id, ProductDTO product);

    void deleteProductById(Long id);
}
