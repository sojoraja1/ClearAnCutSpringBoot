package com.example.sql.demo.services;
/*
 * @author: Sundar Gautam
 * @create date: 7/13/2020
 */

import com.example.sql.demo.entity.Alert;
import com.example.sql.demo.entity.AlertMessage;
import com.example.sql.demo.exception.InternalServerError;
import com.example.sql.demo.repository.AlertMessageRepository;
import com.example.sql.demo.repository.AlertRepository;
import com.example.sql.demo.resource.AlertDto;
import com.example.sql.demo.resource.EmergencyRequest;
import com.example.sql.demo.resource.EmergencyResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class EmergencyServiceImpl implements EmergencyService {
    private final AlertRepository alertRepository;
    private final AlertMessageRepository alertMessageRepository;

    public EmergencyServiceImpl(AlertRepository alertRepository, AlertMessageRepository alertMessageRepository) {
        this.alertRepository = alertRepository;
        this.alertMessageRepository = alertMessageRepository;
    }

    @Override
    public String addAlert(AlertDto alertDto) throws InternalServerError {

        try{

            Alert alert = new Alert();
            alert.setCode(alertDto.getCode());
            alert.setActive(alertDto.getActive());
            alertRepository.save(alert);


        }catch (Exception e){
            throw new InternalServerError("data access error");

        }

        return "uploaded Alert";
    }

    @Override
    public String addAlertMessage(EmergencyRequest emergencyRequest) throws InternalServerError {
        Alert alert = alertRepository.findByCode(emergencyRequest.getCode());
        if (Objects.isNull(alert)){
            throw new InternalServerError("opps");
        }
       try {
           AlertMessage alertMessage = new AlertMessage();
           alertMessage.setAlertHeading(emergencyRequest.getAlertHeading());
           alertMessage.setAlertDescription(emergencyRequest.getAlertDescription());
           alertMessage.setAlert(alert);
           alertMessageRepository.save(alertMessage);
           return "posted message";
       }catch (Exception e){

           throw new InternalServerError("oppss");
       }

    }


    @Override
    public AlertDto showAlert(Long id) throws InternalServerError{
        AlertDto alertDto = new AlertDto();
        try{
           Optional<Alert> alert= alertRepository.findById(id);
        if (alert.isPresent()){
            alert.ifPresent(data->{

                alertDto.setCode(data.getCode());
            });
            return alertDto;
        }
        throw new InternalServerError("ss");
        }catch (Exception exception){
            throw new InternalServerError("sss");
        }

    }

    @Override
    public String updateAlert(Long id) throws InternalServerError {
        try{
            Optional<Alert> alert= alertRepository.findById(id);
            if (alert.isPresent()){
                alert.ifPresent(data->{
                    data.setCode("NAT"+id.toString());
                    alertRepository.save(data);

                });
                return "updated";
            }
            throw new InternalServerError("ss");
        }catch (Exception exception){
            throw new InternalServerError("sss");
        }
    }

    @Override
    public String deleteAlert(Long id) throws InternalServerError{
        try{
            alertRepository.deleteById(id);
        }catch (Exception e){
            throw new InternalServerError("opps");

        }

        return "deleted";
    }

    @Override
    public List<AlertMessage> showAllAlertMessage() {
        List<AlertMessage> alertMessages = alertMessageRepository.findAll();

        return alertMessages;
    }


    @Override
    public List<EmergencyResponse> showAllAlertMessageByAlertId(String code) throws Exception {

        List<EmergencyResponse> emergencyResponses = new ArrayList<EmergencyResponse>();

        try{

            Alert alert = alertRepository.findByCode(code);

            List<AlertMessage> alertMessages = alertMessageRepository.findAllByAlert_Id(alert.getId());
            alertMessages.forEach(data->{
                emergencyResponses.add(new EmergencyResponse(data.getAlertHeading(),data.getAlertDescription(),data.getCreated_at()));
            });

            return emergencyResponses;

        }catch (Exception e){

            System.out.println("cannot demo");
            throw new Exception("sss");

        }



    }

    @Override
    public String updateAlertMessageByMessageId(Long id) {
        return null;
    }

    @Override
    public String demo() {

        alertRepository.customQuery(true);
        alertMessageRepository.customQuery(1l);
        return "fetched";

    }
}
