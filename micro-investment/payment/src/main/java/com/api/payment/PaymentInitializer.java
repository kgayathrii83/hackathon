package com.api.payment;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication(scanBasePackages = {"com.api"})
public class PaymentInitializer extends SpringBootServletInitializer {
    public static void main(String[] args) {
    	System.setProperty("http.proxyHost", "userproxy.rbsgrp.net");
        System.setProperty("http.proxyPort", "8080");
        SpringApplication.run(com.api.payment.PaymentInitializer.class, args);
    }
}
