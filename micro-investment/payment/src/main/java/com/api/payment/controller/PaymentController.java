package com.api.payment.controller;

import com.api.payment.beans.response.AccessTokenResponse;
import com.api.payment.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import static com.api.payment.constant.PaymentConstants.*;

@RestController
public class PaymentController {


    @Autowired
    PaymentService paymentService;

    @PostMapping(value = ACCESS_TOKEN, produces = TYPE_APPLICATION_JSON)
    public ResponseEntity<Object> getAccessToken() throws Exception {
    	System.out.println("Test");
    	AccessTokenResponse response = paymentService.getAccessToken();
        return new ResponseEntity<>(response, HttpStatus.OK);    	
    }
    
    @PostMapping(value = PAYMENTS_INITIATION, produces = TYPE_APPLICATION_JSON)
    public ResponseEntity<Object> paymentInitiation() throws Exception {
        return paymentService.initiatePayment();
    }



}
