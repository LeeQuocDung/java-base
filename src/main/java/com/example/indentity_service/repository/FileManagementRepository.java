package com.example.indentity_service.repository;

import com.example.indentity_service.entity.FileManagement;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FileManagementRepository extends MongoRepository<FileManagement, String> {
    
    // Tìm theo Domain (có thể có RefCode trong children)
    FileManagement findByDomain(String domain);

}
