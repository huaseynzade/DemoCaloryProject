package org.caloryproject.controlles;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.caloryproject.exceptions.ActivateException;
import org.caloryproject.exceptions.InvalidActivationCode;
import org.caloryproject.exceptions.NotFoundException;
import org.caloryproject.exceptions.ResponseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@RequiredArgsConstructor
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseException handle(NotFoundException exception){
        log.info("Error due to {}", exception.getMessage());
        return new ResponseException(exception.getMessage());
    }


    @ExceptionHandler(InvalidActivationCode.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseException handle(InvalidActivationCode exception){
        log.info("Error due to {}", exception.getMessage());
        return new ResponseException(exception.getMessage());
    }



    @ExceptionHandler(ActivateException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseException handle(ActivateException exception){
        log.info("Error due to {}", exception.getMessage());
        return new ResponseException(exception.getMessage());
    }
}
