package com.example.sql.demo.controller;
/*
 * @author: Sundar Gautam
 * @create date: 7/13/2020
 */

import com.example.sql.demo.entity.AlertMessage;
import com.example.sql.demo.exception.InternalServerError;
import com.example.sql.demo.resource.AlertDto;
import com.example.sql.demo.resource.EmergencyRequest;
import com.example.sql.demo.resource.EmergencyResponse;
import com.example.sql.demo.services.EmergencyService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated
public class EmergencyController {

    private final EmergencyService emergencyService;

    public EmergencyController(EmergencyService emergencyService) {
        this.emergencyService = emergencyService;
    }


    @PostMapping("/add/alert")
    public String addAlert(@RequestBody AlertDto alertDto) throws InternalServerError {
        return emergencyService.addAlert(alertDto);
    }

    @PostMapping("/add/alert/message")
    public String addAlertMessage(@RequestBody EmergencyRequest emergencyRequest) throws InternalServerError {

        return emergencyService.addAlertMessage(emergencyRequest);
    }

    @GetMapping("/show/alert/{id}")
    public AlertDto showAlert(@PathVariable("id") Long id) throws InternalServerError {

        return emergencyService.showAlert(id);
    }

    @PutMapping("/alert/{id}")
    public String updateOrDelete(@PathVariable("id") Long id) throws InternalServerError {
        
        return emergencyService.updateAlert(id);

    }
    @DeleteMapping("/alert/{id}")
    public String deleteAlert(@PathVariable("id") Long id) throws InternalServerError {

        return emergencyService.deleteAlert(id);

    }
    
    @GetMapping("/show/alert/message")
    public List<AlertMessage> showAllAlertMessage(){
        return emergencyService.showAllAlertMessage();
    }
    
    @GetMapping("/show/alert/message/{code}")
    public List<EmergencyResponse> showAlertMessageByAlertId(@PathVariable("code") String code) throws Exception {
        return emergencyService.showAllAlertMessageByAlertId(code);
    }

    @GetMapping("/demo")
    public String demo(){

        return emergencyService.demo();
    }
    





}
