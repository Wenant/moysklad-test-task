package ru.biryukov.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.biryukov.dto.SupplyDocumentDTO;
import ru.biryukov.model.Product;
import ru.biryukov.model.SupplyDocument;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SupplyDocumentMapper {

    SupplyDocumentDTO toSupplyDocumentDTO(SupplyDocument supplyDocument);

    List<SupplyDocumentDTO> toSupplyDocumentDTOs(List<SupplyDocument> supplyDocuments);

    @Mapping(target = "productId", ignore = true)
    SupplyDocument toSupplyDocument(SupplyDocumentDTO supplyDocumentDTO);

    List<SupplyDocument> toSupplyDocuments(List<SupplyDocumentDTO> supplyDocumentDTOS);

    default Long map(Product value) {
        return value.getId();
    }
}
