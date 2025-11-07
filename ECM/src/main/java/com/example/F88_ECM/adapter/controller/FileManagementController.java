package com.example.F88_ECM.adapter.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class FileManagementController {

    @GetMapping("/get-file-management")
    public String getFileManagemet() {
        return "ok111";
    }
}
