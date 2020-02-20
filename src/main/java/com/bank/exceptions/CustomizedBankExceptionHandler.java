package com.bank.exceptions;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import ch.qos.logback.core.encoder.EchoEncoder;

@ControllerAdvice
@RestController
public class CustomizedBankExceptionHandler
        extends ResponseEntityExceptionHandler
{
    @ExceptionHandler(BankNotFoundException.class)
    public final ResponseEntity<Object> handleBankNotFoundException(Exception ex, WebRequest request)
    {
        BankExceptionResponse bankExceptionResponse = new BankExceptionResponse(new Date(), ex.getMessage(),
                request.getDescription(false));
        return new ResponseEntity(bankExceptionResponse, HttpStatus.NOT_FOUND);

    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

        BankExceptionResponse bankExceptionResponse = new BankExceptionResponse(new Date(),"Bank name not provide",ex.getBindingResult().toString());
        return new ResponseEntity(bankExceptionResponse,HttpStatus.BAD_REQUEST);
    }

}
