package ru.biryukov.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.biryukov.dto.SupplyDocumentDTO;
import ru.biryukov.response.SuccessResponse;
import ru.biryukov.service.SupplyDocumentService;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class SupplyDocumentController {

    private final SupplyDocumentService supplyDocumentService;

    @GetMapping("/supply-documents")
    public ResponseEntity<List<SupplyDocumentDTO>> getAllSupplyDocuments() {
        List<SupplyDocumentDTO> supplyDocuments = supplyDocumentService.getAllSupplyDocuments();
        return ResponseEntity.ok().body(supplyDocuments);
    }

    @GetMapping("/supply-documents/{id}")
    public ResponseEntity<?> getSupplyDocumentById(@PathVariable Long id) {
        SupplyDocumentDTO supplyDocument = supplyDocumentService.getSupplyDocumentById(id);
        return ResponseEntity.ok().body(supplyDocument);
    }

    @PostMapping("/supply-documents")
    public ResponseEntity<SuccessResponse> createSupplyDocument(@Validated @RequestBody SupplyDocumentDTO supplyDocument) {
        supplyDocumentService.addSupplyDocument(supplyDocument);
        SuccessResponse successResponse = new SuccessResponse(
                LocalDateTime.now(),
                HttpStatus.CREATED.value(),
                "Supply document created successfully");
        return ResponseEntity.status(HttpStatus.CREATED).body(successResponse);
    }

    @PutMapping("/supply-documents/{id}")
    public ResponseEntity<?> updateSupplyDocument(@PathVariable Long id,
                                                  @Validated @RequestBody SupplyDocumentDTO supplyDocument) {
        supplyDocumentService.updateSupplyDocument(id, supplyDocument);
        SuccessResponse successResponse = new SuccessResponse(
                LocalDateTime.now(),
                HttpStatus.OK.value(),
                "Supply document updated successfully");
        return ResponseEntity.ok().body(successResponse);
    }

    @DeleteMapping("/supply-documents/{id}")
    public ResponseEntity<?> deleteSupplyDocumentById(@PathVariable Long id) {
        supplyDocumentService.deleteSupplyDocumentById(id);
        SuccessResponse successResponse = new SuccessResponse(
                LocalDateTime.now(),
                HttpStatus.OK.value(),
                "Supply document deleted successfully");
        return ResponseEntity.ok().body(successResponse);
    }


}
