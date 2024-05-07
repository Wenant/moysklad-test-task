package ru.biryukov.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import ru.biryukov.dto.ProductDTO;
import ru.biryukov.model.Product;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductDTO toProductDTO(Product product);

    List<ProductDTO> toProductDTOs(List<Product> products);

    Product toProduct(ProductDTO productDTO);

    List<Product> toProducts(List<ProductDTO> productDTOS);

    @Mapping(target = "id", ignore = true)
    void updateProductFromDTO(ProductDTO productDTO, @MappingTarget Product product);

}