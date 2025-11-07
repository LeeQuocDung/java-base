package com.example.F88_ECM.domain.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
public class FileManagement {
    @Id
    String id;

    @Schema(description = "Mã hệ thống. VD los,isr,cif,..")
    @Field(value = "Domain")
    String domain;
    @Schema(description = "Loại file. Dùng để phân biệt bản ghi cùng Domain + RefCode")
    @Field(value = "FileType")
    String fileType;
}
