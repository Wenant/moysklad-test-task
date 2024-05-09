package ru.biryukov.service;

import org.springframework.stereotype.Service;
import ru.biryukov.dto.SupplyDocumentDTO;

import java.util.List;

@Service
public interface SupplyDocumentService {

    void addSupplyDocument(SupplyDocumentDTO supplyDocument);

    List<SupplyDocumentDTO> getAllSupplyDocuments();

    SupplyDocumentDTO getSupplyDocumentById(Long id);

    void updateSupplyDocument(Long id, SupplyDocumentDTO supplyDocument);

    void deleteSupplyDocumentById(Long id);


}
