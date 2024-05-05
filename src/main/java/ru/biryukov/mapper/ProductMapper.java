package ru.biryukov.mapper;

import org.mapstruct.Mapper;
import ru.biryukov.dto.ProductDTO;
import ru.biryukov.model.Product;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductDTO toProductDTO(Product product);

    List<ProductDTO> toProductDTOs(List<Product> products);

    Product toProduct(ProductDTO productDTO);

    List<Product> toProducts(List<ProductDTO> productDTOS);
}
