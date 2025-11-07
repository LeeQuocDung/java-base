package com.example.F88_ECM.application.common.service;

import com.example.F88_ECM.infrastructure.repository.FileManagementRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor()
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FileManagementSerivce {

    FileManagementRepository fileManagementRepository;

     String getFileManagementById(String id) {
        return fileManagementRepository.getFileManagementById(id);
    }
}
