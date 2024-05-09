package ru.biryukov.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import ru.biryukov.dto.SupplyDocumentDTO;
import ru.biryukov.model.Product;
import ru.biryukov.model.SupplyDocument;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SupplyDocumentMapper {

    SupplyDocumentDTO toSupplyDocumentDTO(SupplyDocument supplyDocument);

    List<SupplyDocumentDTO> toSupplyDocumentDTOs(List<SupplyDocument> supplyDocuments);

    @Mapping(target = "productId", ignore = true)
    @Mapping(target = "id", ignore = true)
    SupplyDocument toSupplyDocument(SupplyDocumentDTO supplyDocumentDTO);

    List<SupplyDocument> toSupplyDocuments(List<SupplyDocumentDTO> supplyDocumentDTOS);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "productId", ignore = true)
    void updateSupplyDocumentFromDTO(SupplyDocumentDTO supplyDocumentDTO, @MappingTarget SupplyDocument supplyDocument);

    default Long map(Product value) {
        return value.getId();
    }
}
