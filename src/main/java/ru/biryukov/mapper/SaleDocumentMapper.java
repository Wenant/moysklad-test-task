package ru.biryukov.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
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


    default Long map(Product value) {
        return value.getId();
    }
}
