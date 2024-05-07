package ru.biryukov.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.biryukov.dto.ProductDTO;
import ru.biryukov.response.SuccessResponse;
import ru.biryukov.service.ProductService;

import java.time.LocalDateTime;
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
    public ResponseEntity<SuccessResponse> createProduct(@Validated @RequestBody ProductDTO product) {
        productService.addProduct(product);
        SuccessResponse successResponse = new SuccessResponse(
                LocalDateTime.now(),
                HttpStatus.CREATED.value(),
                "Product created successfully");
        return ResponseEntity.status(HttpStatus.CREATED).body(successResponse);
    }

    @GetMapping("/products/{productId}")
    public ResponseEntity<?> getProductById(@PathVariable Long productId) {
        ProductDTO product = productService.getProductById(productId);
        return ResponseEntity.ok().body(product);
    }

    @PutMapping("/products/{productId}")
    public ResponseEntity<?> updateProduct(@PathVariable Long productId, @Validated @RequestBody ProductDTO product) {
        productService.updateProduct(productId, product);
        SuccessResponse successResponse = new SuccessResponse(
                LocalDateTime.now(),
                HttpStatus.OK.value(),
                "Product updated successfully");

        return ResponseEntity.ok().body(successResponse);
    }

    @DeleteMapping("/products/{productId}")
    public ResponseEntity<?> deleteProductById(@PathVariable Long productId) {
        productService.deleteProductById(productId);
        SuccessResponse successResponse = new SuccessResponse(
                LocalDateTime.now(),
                HttpStatus.OK.value(),
                "Product deleted successfully");
        return ResponseEntity.ok().body(successResponse);
    }

}