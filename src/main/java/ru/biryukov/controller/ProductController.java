package ru.biryukov.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.biryukov.dto.ProductDTO;
import ru.biryukov.service.ProductService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class ProductController {

    private final ProductService productService;

    @GetMapping("/products")
    public ResponseEntity<List<ProductDTO>> getAllProducts() {
        List<ProductDTO> products = productService.getAllProducts();
        return ResponseEntity.ok().body(products);
    }

    @PostMapping("/products")
    public ResponseEntity<String> createProduct(@Validated @RequestBody ProductDTO product) {
        productService.addProduct(product);
        return ResponseEntity.ok("Product created successfully");
    }

    @GetMapping("/products/{productId}")
    public ResponseEntity<?> getProductById(@PathVariable int productId) {
        ProductDTO product = productService.getProductById(productId);
        return ResponseEntity.ok().body(product);
    }

    @PutMapping("/products/{productId}")
    public ResponseEntity<?> updateProduct(@PathVariable int productId, @Validated @RequestBody ProductDTO product) {
        productService.updateProduct(productId, product);
        return ResponseEntity.ok().body("Product updated successfully");
    }

    @DeleteMapping("/products/{productId}")
    public ResponseEntity<?> deleteProductById(@PathVariable int productId) {
        productService.deleteProductById(productId);
        return ResponseEntity.ok().body("Product deleted successfully");
    }

}