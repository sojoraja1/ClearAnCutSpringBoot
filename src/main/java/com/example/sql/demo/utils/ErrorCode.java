package com.example.sql.demo.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;

/*
 * @author: Sundar Gautam
 * @create date: 7/8/2020
 */
@AllArgsConstructor
@Getter
public enum ErrorCode {
    VALIDATION_ERROR("BABA-404"),
    REQUEST_BODY_ERROR("BABA-400"),
    INTERNAL_ERROR("BABA-100"),
    DATA_ACCESS("BABA-406");
    private final String message;
}
