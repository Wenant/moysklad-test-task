package ru.biryukov.service;

import org.springframework.stereotype.Service;
import ru.biryukov.dto.SaleDocumentDTO;

import java.util.List;

@Service
public interface SaleDocumentService {

    void addSaleDocument(SaleDocumentDTO saleDocument);

    List<SaleDocumentDTO> getAllSaleDocuments();

    SaleDocumentDTO getSaleDocumentById(Long id);

    void updateSaleDocument(Long id, SaleDocumentDTO saleDocument);

    void deleteSaleDocumentById(Long id);


}
