package com.gaurav.jpa.hibernate.foodproject.repository.exceptions.handler;

import com.gaurav.jpa.hibernate.foodproject.repository.exceptions.MenuInstanceException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@RestController
@ControllerAdvice
public class CustomExceptionResponseHandler  extends ResponseEntityExceptionHandler {


    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllException(Exception ex, WebRequest request)  {
        ExceptionResponse exceptionResponse = new ExceptionResponse(LocalDateTime.now(),request.getDescription(false),ex.getMessage());
        return new ResponseEntity(exceptionResponse,HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @ExceptionHandler(MenuInstanceException.class)
    public final ResponseEntity<Object> handleUserNotFoundException(Exception ex, WebRequest request)  {
        ExceptionResponse exceptionResponse = new ExceptionResponse(LocalDateTime.now(),request.getDescription(false),ex.getMessage());
        return new ResponseEntity(exceptionResponse,HttpStatus.NOT_FOUND);
    }


    //The handleMethodArgumentNotValid handles the MethodArgumentNotValidException which is thrown when validation on an argument annotated with @Valid fails.
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(LocalDateTime.now(),ex.getBindingResult().toString(),ex.getMessage());
        return new ResponseEntity(exceptionResponse,HttpStatus.BAD_REQUEST);
    }

    // This handles Controller level validation for path or request variable;
    @Override
    protected ResponseEntity<Object> handleTypeMismatch(TypeMismatchException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(LocalDateTime.now(),ex.getMessage(),ex.getMessage());
        return new ResponseEntity(exceptionResponse,HttpStatus.BAD_REQUEST);
    }
}
