package ru.biryukov.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.biryukov.dto.SupplyDocumentDTO;
import ru.biryukov.exception.ProductNotFoundException;
import ru.biryukov.mapper.SupplyDocumentMapper;
import ru.biryukov.model.Product;
import ru.biryukov.model.SupplyDocument;
import ru.biryukov.repository.ProductRepository;
import ru.biryukov.repository.SupplyDocumentRepository;
import ru.biryukov.service.SupplyDocumentService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SupplyDocumentServiceImpl implements SupplyDocumentService {

    private final SupplyDocumentMapper mapper;
    private final SupplyDocumentRepository supplyDocumentRepository;
    private final ProductRepository productRepository;
    @Override
    public void addSupplyDocument(SupplyDocumentDTO supplyDocument) {
        Product product = getProductById(supplyDocument.getProductId());
        SupplyDocument supply = mapper.toSupplyDocument(supplyDocument);
        supply.setProductId(product);
        supplyDocumentRepository.save(supply);



    }

    @Override
    public List<SupplyDocumentDTO> getAllSupplyDocuments() {
        var supplyDocuments = supplyDocumentRepository.findAll();
        return mapper.toSupplyDocumentDTOs(supplyDocuments);
    }

    @Override
    public SupplyDocumentDTO getSupplyDocumentById(Long id) {
        var supplyDocument = supplyDocumentRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Document with id " + id + " not found"));
        return mapper.toSupplyDocumentDTO(supplyDocument);
    }

    @Override
    public void updateSupplyDocument(Long id, SupplyDocumentDTO supplyDocument) {
        var supply = supplyDocumentRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Document with id " + id + " not found"));

        Product product = productRepository.findById(supplyDocument.getProductId())
                .orElseThrow(() -> new ProductNotFoundException("Product with id " + id + " not found"));

        mapper.updateSupplyDocumentFromDTO(supplyDocument, supply);
        supply.setProductId(product);
        supplyDocumentRepository.save(supply);
    }

    @Override
    public void deleteSupplyDocumentById(Long id) {
        supplyDocumentRepository.deleteById(id);
    }

    private Product getProductById(Long productId) {
        return productRepository.findById(productId)
                .orElseThrow(() -> new ProductNotFoundException("Product with ID " + productId + " not found"));
    }
}
