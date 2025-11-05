package com.example.indentity_service.dto.request;

import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserCreationRequest {
    String username;
    @Size(min = 6, max = 20, message = "Password phải từ 6 đến 20 kí tự")
    String password;
    String firstName;
    String lastName;
    LocalDate dob ;
}
