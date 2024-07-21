package com.api.payment.service;

import org.springframework.http.ResponseEntity;

import com.api.payment.beans.response.AccessTokenResponse;

public interface PaymentService {
    ResponseEntity<Object> initiatePayment() throws Exception;
    AccessTokenResponse getAccessToken() throws Exception;
}
