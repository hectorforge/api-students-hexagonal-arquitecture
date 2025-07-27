package com.hex.app.infrastructure.adapters;

import com.hex.app.domain.exception.StudentNotFoundException;
import com.hex.app.domain.model.ErrorResponse;
import com.hex.app.utils.ErrorCatalog;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.stream.Collectors;

import static com.hex.app.utils.ErrorCatalog.*;

@RestControllerAdvice
public class GlobalControllerAdvice {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(StudentNotFoundException.class)
    public ErrorResponse handleStudentNotFoundException() {
        return ErrorResponse.builder()
                .code(STUDENT_NOT_FOUND.getCode())
                .message(STUDENT_NOT_FOUND.getMessage())
                .timestamp(LocalDateTime.now())
                .build();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ErrorResponse handleMethodArgumentNotValidException
            (MethodArgumentNotValidException ex) {

        BindingResult result = ex.getBindingResult();

        return ErrorResponse.builder()
                .code(INVALID_STUDENT.getCode())
                .message(INVALID_STUDENT.getMessage())
                .details(result.getFieldErrors().stream()
                        .map(DefaultMessageSourceResolvable::getDefaultMessage)
                        .collect(Collectors.toList()))
                .timestamp(LocalDateTime.now())
                .build();
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public ErrorResponse handleException(Exception ex) {
        return ErrorResponse.builder()
                .code(GENERIC_ERROR.getCode())
                .message(GENERIC_ERROR.getMessage())
                .details(Collections.singletonList(GENERIC_ERROR.getMessage()))
                .timestamp(LocalDateTime.now())
                .build();
    }
}
