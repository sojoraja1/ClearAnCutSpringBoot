package com.example.sql.demo.services;
/*
 * @author: Sundar Gautam
 * @create date: 7/13/2020
 */

import com.example.sql.demo.entity.AlertMessage;
import com.example.sql.demo.exception.InternalServerError;
import com.example.sql.demo.resource.AlertDto;
import com.example.sql.demo.resource.EmergencyRequest;
import com.example.sql.demo.resource.EmergencyResponse;

import java.util.List;

public interface EmergencyService {

    String addAlert(AlertDto alertDto) throws InternalServerError;

    String addAlertMessage(EmergencyRequest emergencyRequest) throws InternalServerError;

    AlertDto showAlert(Long id) throws InternalServerError;

    String updateAlert(Long id) throws InternalServerError;

    String deleteAlert(Long id) throws InternalServerError;

    List<AlertMessage> showAllAlertMessage();

    List<EmergencyResponse> showAllAlertMessageByAlertId(String code) throws Exception;

    String updateAlertMessageByMessageId(Long id);

    String demo();
}
