package com.example.sql.demo.resource;
/*
 * @author: Sundar Gautam
 * @create date: 7/13/2020
 */

import com.example.sql.demo.entity.AlertMessage;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class EmergencyRequest{

    @JsonProperty("dep_code")
    private String  code;

    @JsonProperty("alert_heading")
    private String alertHeading;

    @JsonProperty("alert_description")
    private String alertDescription;


}
