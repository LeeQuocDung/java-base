package com.example.indentity_service.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.data.annotation.Id;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "FileManagement")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
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
