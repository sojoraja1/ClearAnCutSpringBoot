package com.example.sql.demo.exception;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

/*
 * @author: Sundar Gautam
 * @create date: 7/8/2020
 */
@Data
@AllArgsConstructor
@JsonIgnoreProperties(value = {"error_occurred_time"})
public class CustomErrorMessage {

    @JsonProperty(value = "error_message", required = true)
    private String errorMessage;

    @JsonProperty("code")
    private String errorDescription;

    @JsonProperty("error_occurred_time")
    private Date errorOccurredDate;
}
