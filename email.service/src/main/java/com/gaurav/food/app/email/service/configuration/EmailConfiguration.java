package com.gaurav.food.app.email.service.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


@Component
@ConfigurationProperties("food-app-email-service")
public class EmailConfiguration {

    private String from_email;
    private String from_name;
    private String smtp_username;
    private String smtp_password;
    private String smtp_host;
    private Integer smtp_port;


    public String getFrom_email() {
        return from_email;
    }

    public void setFrom_email(String from_email) {
        this.from_email = from_email;
    }

    public String getFrom_name() {
        return from_name;
    }

    public void setFrom_name(String from_name) {
        this.from_name = from_name;
    }

    public String getSmtp_username() {
        return smtp_username;
    }

    public void setSmtp_username(String smtp_username) {
        this.smtp_username = smtp_username;
    }

    public String getSmtp_password() {
        return smtp_password;
    }

    public void setSmtp_password(String smtp_password) {
        this.smtp_password = smtp_password;
    }

    public String getSmtp_host() {
        return smtp_host;
    }

    public void setSmtp_host(String smtp_host) {
        this.smtp_host = smtp_host;
    }

    public Integer getSmtp_port() {
        return smtp_port;
    }

    public void setSmtp_port(Integer smtp_port) {
        this.smtp_port = smtp_port;
    }



}
