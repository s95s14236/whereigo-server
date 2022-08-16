package com.whereigo.model;

import java.util.Map;

import lombok.Data;

@Data
public class ApiResponse {
    private String message;
    private Integer statusCode;

    private Map<String, Object> data;
}
