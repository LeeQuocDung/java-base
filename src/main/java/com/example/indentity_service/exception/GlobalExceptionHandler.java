package com.example.indentity_service.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = RuntimeException.class)
    ResponseEntity<String> handlingRuntimeException(RuntimeException ex)
    {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }
//    @ExceptionHandler(value = Exception.class)
//    ResponseEntity<String> handlingException(Exception ex)
//    {
//        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Đã xảy ra lỗi trong quá trình xử lý!");
//    }
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    ResponseEntity<String> handlingValidationException(MethodArgumentNotValidException ex)
    {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getFieldError().getDefaultMessage());
    }

    @ExceptionHandler(value = ServerExCeption.class)
    ResponseEntity<String> HandlingServerExCeption(ServerExCeption ex)
    {
        return ResponseEntity.status(ex.getErrorCode().getCode()).body(ex.getMessage());
    }
}
