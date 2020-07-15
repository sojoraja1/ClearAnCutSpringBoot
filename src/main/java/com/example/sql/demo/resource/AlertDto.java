package com.example.sql.demo.resource;
/*
 * @author: Sundar Gautam
 * @create date: 7/13/2020
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class AlertDto {
    @NotEmpty
    @JsonProperty("dep_code")
    private String code;

    @JsonProperty("active")
    private Boolean active;
}
