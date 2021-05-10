package com.example.laborator11compulsory.controllers;

import com.example.laborator11compulsory.models.ErrorMessage;
import com.example.laborator11compulsory.models.MyException;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@RestControllerAdvice
//@ControllerAdvice
//@ResponseBody
public class ExceptionController{

    @ExceptionHandler(value = MyException.class)
    public ResponseEntity<ErrorMessage> handleResourceNotFoundException(MyException ex) {
        ErrorMessage message = new ErrorMessage(
                HttpStatus.NOT_FOUND.value(),
                new Date(),
                ex.getMessage());
        return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
    }
}