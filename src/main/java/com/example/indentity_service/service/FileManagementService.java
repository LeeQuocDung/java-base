package com.example.indentity_service.service;

import com.example.indentity_service.dto.request.GetFileByRefCodeRequest;
import com.example.indentity_service.entity.FileManagement;
import com.example.indentity_service.repository.FileManagementRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE , makeFinal = true)
public class FileManagementService {
    FileManagementRepository fileManagementRepository;

    public Optional<FileManagement> getFile(GetFileByRefCodeRequest getFileByRefCodeRequest) {
        return fileManagementRepository.findById(getFileByRefCodeRequest.getId());
    }
}
