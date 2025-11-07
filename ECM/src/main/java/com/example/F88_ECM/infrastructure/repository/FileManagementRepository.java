package com.example.F88_ECM.infrastructure.repository;

import com.example.F88_ECM.domain.entity.FileManagement;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileManagementRepository extends MongoRepository<FileManagement,String> {

    String getFileManagementById(String id);
}
