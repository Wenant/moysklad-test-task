package ru.biryukov.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.biryukov.dto.SaleDocumentDTO;
import ru.biryukov.response.SuccessResponse;
import ru.biryukov.service.SaleDocumentService;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class SaleDocumentController {

    private final SaleDocumentService saleDocumentService;

    @PostMapping("/sale-documents")
    public ResponseEntity<SuccessResponse> createSaleDocument(@Validated @RequestBody SaleDocumentDTO saleDocument) {
        saleDocumentService.addSaleDocument(saleDocument);
        SuccessResponse successResponse = new SuccessResponse(
                LocalDateTime.now(),
                HttpStatus.CREATED.value(),
                "Sale document created successfully");
        return ResponseEntity.status(HttpStatus.CREATED).body(successResponse);
    }

    @GetMapping("/sale-documents")
    public ResponseEntity<List<SaleDocumentDTO>> getAllSaleDocuments() {
        List<SaleDocumentDTO> saleDocuments = saleDocumentService.getAllSaleDocuments();
        return ResponseEntity.ok().body(saleDocuments);
    }


}
