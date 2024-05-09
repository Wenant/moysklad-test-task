package ru.biryukov.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.biryukov.model.SupplyDocument;

@Repository
public interface SupplyDocumentRepository extends JpaRepository<SupplyDocument, Long> {
}