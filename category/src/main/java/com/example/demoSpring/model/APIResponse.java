package com.example.demoSpring.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class APIResponse<T> {
    private String message;
    private HttpStatus status;
    private T payload;
    private LocalDateTime dateTime;
}