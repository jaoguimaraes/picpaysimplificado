package com.picpaysimplificado.infra;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration //para indicar que esta é uma classe de configuração
public class AppConfig {
    @Bean //
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
