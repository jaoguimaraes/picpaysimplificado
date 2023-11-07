package com.picpaysimplificado.infra;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration //para indicar que esta é uma classe de configuração
public class AppConfig {
    @Bean //Capaz de oferecer mais controle desta classe por outro serviço
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
