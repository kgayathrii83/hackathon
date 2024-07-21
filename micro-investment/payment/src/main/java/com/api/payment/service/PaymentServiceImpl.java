package com.api.payment.service;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.api.payment.beans.response.AccessTokenResponse;
import static com.api.payment.constant.PaymentConstants.*;

public class PaymentServiceImpl implements PaymentService {

    @Autowired
    RestTemplate restTemplate;
	
	@Override
    public AccessTokenResponse getAccessToken() throws Exception {
        // Access Token
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        MultiValueMap<String, String> map = new LinkedMultiValueMap();
        map.add("client_id", CLIENT_ID);
        map.add("client_secret", CLIENT_SECRET);
        map.add("scope", "payment");
//        map.add("client_assertion_type", "urn:ietf:params:oauth:client-assertion-type:jwt-bearer");
//        map.add("client_assertion", jwttoken);
        map.add("grant_type", "client_credentials");
        HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(map, headers);
        ResponseEntity<AccessTokenResponse> response = null;
        try {
            response =
                    restTemplate.exchange(TOKEN_ENDPOINT_URL,
                            HttpMethod.POST,
                            entity,
                            AccessTokenResponse.class);
            return response.getBody();
        } catch (RestClientException e) {
        	e.printStackTrace();
//            log.error("Error in getting access token", e);
        	System.out.println(e);
        }
        return response != null ? response.getBody() : null;
    
    }
	
    @Override
    public ResponseEntity<Object> initiatePayment() throws Exception {
        return null;
    }

    
}
