package ru.biryukov.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.biryukov.dto.ProductDTO;
import ru.biryukov.mapper.ProductMapper;
import ru.biryukov.repository.ProductRepository;
import ru.biryukov.service.ProductService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;


    @Override
    public void addProduct(ProductDTO productDTO) {
        var product = productMapper.toProduct(productDTO);
        productRepository.addProduct(product);
    }

    @Override
    public List<ProductDTO> getAllProducts() {
        var products = productRepository.getAllProducts();
        return productMapper.toProductDTOs(products);
    }

    @Override
    public ProductDTO getProductById(int id) {
        var product = productRepository.getProductById(id);
        return productMapper.toProductDTO(product);
    }

    @Override
    public void updateProduct(int id, ProductDTO productDTO) {
        var product = productMapper.toProduct(productDTO);
        productRepository.updateProduct(id, product);
    }

    @Override
    public void deleteProductById(int id) {
        productRepository.deleteProductById(id);
    }
}