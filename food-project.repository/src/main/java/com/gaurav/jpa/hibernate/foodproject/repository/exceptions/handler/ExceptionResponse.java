package com.gaurav.jpa.hibernate.foodproject.repository.exceptions.handler;

import java.time.LocalDateTime;

public class ExceptionResponse {

    private LocalDateTime dateTime;
    private String details;
    private String message;

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public String getDetails() {
        return details;
    }

    public String getMessage() {
        return message;
    }

    public ExceptionResponse(LocalDateTime dateTime, String details, String message) {
        this.dateTime = dateTime;
        this.details = details;
        this.message = message;
    }
}
