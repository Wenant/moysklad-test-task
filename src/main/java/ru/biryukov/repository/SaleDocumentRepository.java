package ru.biryukov.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.biryukov.model.SaleDocument;

@Repository
public interface SaleDocumentRepository extends JpaRepository<SaleDocument, Long> {
}