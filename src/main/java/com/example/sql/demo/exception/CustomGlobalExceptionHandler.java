package com.example.sql.demo.exception;

import com.example.sql.demo.utils.ErrorCode;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ConstraintViolationException;
import java.util.Date;

@ControllerAdvice
public class CustomGlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllException(Exception ex, WebRequest request) {
        CustomErrorMessage customErrorResponse = new CustomErrorMessage(
                "opps", ErrorCode.INTERNAL_ERROR.getMessage(), new Date());
        return new ResponseEntity<>(customErrorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InternalServerError.class)
    public final ResponseEntity<Object> dataBaseErrorException(Exception ex, WebRequest request) {
        CustomErrorMessage customErrorResponse = new CustomErrorMessage(
                "data access error", ErrorCode.DATA_ACCESS.getMessage(), new Date());
        return new ResponseEntity<>(customErrorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public final ResponseEntity<Object> handleConstraintException(ConstraintViolationException ex, WebRequest request) {
        System.out.println(ex.getMessage());
        CustomErrorMessage customErrorResponse = new CustomErrorMessage("invalid ulr ",
                ErrorCode.VALIDATION_ERROR.getMessage(), new Date());
        return new ResponseEntity<>(customErrorResponse, HttpStatus.BAD_REQUEST);
    }

    /**
     * @param ex exeption
     * @param headers http headers
     * @param status  check http staus
     * @param request resource
     * @return message
     */
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers,
                                                                  HttpStatus status, WebRequest request) {
        CustomErrorMessage customErrorMessage = new CustomErrorMessage("invalid_body", ErrorCode.REQUEST_BODY_ERROR.getMessage(), new Date());
        return new ResponseEntity<>(customErrorMessage, HttpStatus.BAD_REQUEST);

    }
}
