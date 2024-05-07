package ru.biryukov.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.biryukov.dto.ProductDTO;
import ru.biryukov.exception.ProductNotFoundException;
import ru.biryukov.mapper.ProductMapper;
import ru.biryukov.model.Product;
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
        productRepository.save(product);
    }

    @Override
    public List<ProductDTO> getAllProducts() {
        var products = productRepository.findAll();
        return productMapper.toProductDTOs(products);
    }

    @Override
    public ProductDTO getProductById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product with id " + id + " not found"));

        return productMapper.toProductDTO(product);
    }

    @Override
    public void updateProduct(Long id, ProductDTO productDTO) {
        Product existingProduct = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product with id " + id + " not found"));

        productMapper.updateProductFromDTO(productDTO, existingProduct);
        productRepository.save(existingProduct);
    }

    @Override
    public void deleteProductById(Long id) {
        productRepository.deleteById(id);
    }

    private void validateProductExists(Long id) {
        if (!productRepository.existsById(id)) {
            throw new ProductNotFoundException("Product with id " + id + " not found");
        }
    }
}