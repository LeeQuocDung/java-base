package com.example.indentity_service.controller;

import com.example.indentity_service.dto.request.GetFileByRefCodeRequest;
import com.example.indentity_service.entity.FileManagement;
import com.example.indentity_service.service.FileManagementService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/file-management")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class FileManagementController {

    FileManagementService fileManagementService;

    @PostMapping("/get-by-ref-code")
    public Optional<FileManagement> getFileByRefCodeParent(@RequestBody @Valid GetFileByRefCodeRequest request) {
        return fileManagementService.getFile(request);
    }
}
