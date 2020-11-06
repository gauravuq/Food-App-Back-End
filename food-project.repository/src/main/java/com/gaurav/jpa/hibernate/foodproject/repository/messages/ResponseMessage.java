package com.gaurav.jpa.hibernate.foodproject.repository.messages;

public class ResponseMessage {

    private String message;
    private String action;
    private Long id;
    private String item;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public ResponseMessage(String message, String action, Long id, String item) {
        this.message = message;
        this.action = action;
        this.id = id;
        this.item = item;
    }

    public ResponseMessage() {
    }
}
