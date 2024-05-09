package ru.biryukov.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.biryukov.dto.SaleDocumentDTO;
import ru.biryukov.exception.ProductNotFoundException;
import ru.biryukov.mapper.SaleDocumentMapper;
import ru.biryukov.model.Product;
import ru.biryukov.model.SaleDocument;
import ru.biryukov.repository.ProductRepository;
import ru.biryukov.repository.SaleDocumentRepository;
import ru.biryukov.service.SaleDocumentService;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SaleDocumentServiceImpl implements SaleDocumentService {

    private final SaleDocumentRepository saleDocumentRepository;
    private final ProductRepository productRepository;
    private final SaleDocumentMapper mapper;

    public void addSaleDocument(SaleDocumentDTO saleDocument) {
        Product product = getProductById(saleDocument.getProductId());
        SaleDocument sale = mapper.toSaleDocument(saleDocument);
        sale.setProductId(product);
        sale.setTotalCost(coutTotalCost(sale, product));
        saleDocumentRepository.save(sale);

    }

    @Override
    public List<SaleDocumentDTO> getAllSaleDocuments() {
        return null;
    }

    @Override
    public SaleDocumentDTO getSaleDocumentById(Long id) {
        return null;
    }

    @Override
    public void updateSaleDocument(Long id, SaleDocumentDTO saleDocument) {

    }

    @Override
    public void deleteSaleDocumentById(Long id) {

    }


    private Product getProductById(Long productId) {
        return productRepository.findById(productId)
                .orElseThrow(() -> new ProductNotFoundException("Product with ID " + productId + " not found"));
    }

    private BigDecimal coutTotalCost(SaleDocument saleDocument, Product product) {
        var productPrice = product.getPrice();
        var quantity = saleDocument.getQuantity();
        return new BigDecimal(quantity).multiply(productPrice);
    }

}
