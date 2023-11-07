package com.picpaysimplificado.services;

import com.picpaysimplificado.domain.user.User;
import com.picpaysimplificado.dtos.NotificationDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
@Slf4j
@Service
public class NotificationService {
    @Autowired
    private RestTemplate restTemplate;

    public void sendNotification(final User user, String message) throws Exception {
        String email = user.getEmail();
        NotificationDTO notificationRequest = new NotificationDTO(email, message);
        ResponseEntity<String> notificationResponse
                = restTemplate.postForEntity("https://picpayapitest.free.beeceptor.com",
                notificationRequest, String.class);

       log.info("is server authorized: {}", notificationResponse);

       if (!(notificationResponse.getStatusCode() == HttpStatus.OK)) {
            log.error("Erro ao enviar notificação");
            throw new Exception("Servico de notificação está fora do ar");
        }
    }
}