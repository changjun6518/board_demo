package com.jj.demo.common.model;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomResponse<T> {
    private LocalDateTime transactionTime;
    private String resultCode;
    private String description;
    private T data;
    private Pagination pagination;

    public static <T> CustomResponse<T> ok() {
        return (CustomResponse<T>) CustomResponse.builder()
                .transactionTime(LocalDateTime.now())
                .resultCode("OK")
                .description("OK")
                .build();
    }

    //DATA OK
    public static <T> CustomResponse<T> ok(T data) {
        return (CustomResponse<T>) CustomResponse.builder()
                .transactionTime(LocalDateTime.now())
                .resultCode("OK")
                .description("OK")
                .data(data)
                .build();
    }

    public static <T> CustomResponse<T> ok(T data, Pagination pagination) {
        return (CustomResponse<T>) CustomResponse.builder()
                .transactionTime(LocalDateTime.now())
                .resultCode("OK")
                .description("OK")
                .data(data)
                .pagination(pagination)
                .build();
    }

    public static <T> CustomResponse<T> ERROR(String description) {
        return (CustomResponse<T>) CustomResponse.builder()
                .transactionTime(LocalDateTime.now())
                .resultCode("ERROR")
                .description(description)
                .build();
    }
}