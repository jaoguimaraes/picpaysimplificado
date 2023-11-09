package com.picpaysimplificado.services;

import com.picpaysimplificado.domain.user.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.Map;

@Service
@Slf4j
public class AuthorizationService {

    @Autowired
    private RestTemplate restTemplate;

    public boolean authorizeTransaction(final User sender, BigDecimal value){
        ResponseEntity<Map> authorizationResponse = restTemplate.getForEntity("https://picpayapitest.free.beeceptor.com", Map.class);

        log.info("is server authorized: {}", authorizationResponse.getBody());
        log.info("server status code: {}", authorizationResponse.getStatusCode());
        if(authorizationResponse.getStatusCode() == HttpStatus.OK) {
            return (boolean) authorizationResponse.getBody().get("authorized");
        } else {
            return false;
        }
    }
}