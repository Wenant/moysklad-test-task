package ru.biryukov.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import ru.biryukov.dto.ProductDTO;
import ru.biryukov.dto.ProductFilterDTO;
import ru.biryukov.exception.ProductNotFoundException;
import ru.biryukov.mapper.ProductMapper;
import ru.biryukov.model.Product;
import ru.biryukov.repository.ProductRepository;
import ru.biryukov.service.ProductService;
import ru.biryukov.util.PageRequestBuilder;
import ru.biryukov.util.ProductSpecificationBuilder;

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
    public List<ProductDTO> getAllProducts(ProductFilterDTO filter) {
        var name = filter.getName();
        var minPrice = filter.getMinPrice();
        var maxPrice = filter.getMaxPrice();
        var available = filter.getAvailable();
        var page = filter.getPage();
        var size = filter.getSize();
        var sortBy = filter.getSortBy();
        var sortDirection = filter.getSortDirection();

        Specification<Product> spec = ProductSpecificationBuilder.buildSpecification(
                name,
                minPrice,
                maxPrice,
                available);

        PageRequest pageRequest = PageRequestBuilder.buildPageRequest(page, size, sortBy, sortDirection);
        List<Product> products = productRepository.findAll(spec, pageRequest).getContent();
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

}