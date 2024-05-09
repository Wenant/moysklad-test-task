package ru.biryukov.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import ru.biryukov.dto.SaleDocumentDTO;
import ru.biryukov.model.Product;
import ru.biryukov.model.SaleDocument;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SaleDocumentMapper {


    SaleDocumentDTO toSaleDocumentDTO(SaleDocument saleDocument);

    List<SaleDocumentDTO> toSaleDocumentDTOs(List<SaleDocument> saleDocuments);

    @Mapping(target = "productId", ignore = true)
    @Mapping(target = "totalCost", ignore = true)
    @Mapping(target = "id", ignore = true)
    SaleDocument toSaleDocument(SaleDocumentDTO saleDocumentDTO);

    List<SaleDocument> toSaleDocuments(List<SaleDocumentDTO> saleDocumentDTOS);


    @Mapping(target = "id", ignore = true)
    @Mapping(target = "productId", ignore = true)
    void updateSaleDocumentFromDTO(SaleDocumentDTO saleDocumentDTO, @MappingTarget SaleDocument saleDocument);


    default Long map(Product value) {
        return value.getId();
    }
}
