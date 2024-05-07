package ru.biryukov.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class SuccessResponse {
    private LocalDateTime timestamp;
    private int status;
    private String message;
}
