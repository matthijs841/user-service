package nl.springms.microservice.controller;

import nl.springms.microservice.exception.ConstraintViolationException;
import nl.springms.microservice.exception.UserNotFoundByUserNameException;
import nl.springms.microservice.exception.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class MyControllerAdvice {
    @ResponseBody
    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String userNotFoundHandler(UserNotFoundException userNotFoundException){
        return userNotFoundException.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    String constraintViolation(ConstraintViolationException constraintViolationException){
        return "Username already exists! Pick another username.";
    }

    @ResponseBody
    @ExceptionHandler(UserNotFoundByUserNameException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String userNotFoundByUserName(UserNotFoundByUserNameException userNotFoundByUserNameException){
        return userNotFoundByUserNameException.getMessage();
    }

}
