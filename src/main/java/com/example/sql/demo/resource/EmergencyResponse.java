package com.example.sql.demo.resource;
/*
 * @author: Sundar Gautam
 * @create date: 7/13/2020
 */

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmergencyResponse {

    @JsonProperty("alert_heading")
    private String heading;

    @JsonProperty("alert_description")
    private String description;

    @JsonProperty("posted_at")
    @JsonFormat(pattern = "yyyy-MM-dd@HH:mm:ss.SSS")
    private Date date;
    
}
