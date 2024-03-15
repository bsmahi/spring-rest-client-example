package com.bsmlabs.restclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestClient;

@Configuration
public class RestClientConfig {

    @Value("${universityEndpointUrl}")
    String baseUri;

    /**
     * using RestClient static create method
     */
    @Bean
    RestClient restClient() {
        return RestClient.create(baseUri);
    }

    /**
     * Using RestClient Builder Pattern
     */
    @Bean(name = "builderRestClient")
    RestClient restClientBuilder() {
        return RestClient.builder()
                .requestFactory(new HttpComponentsClientHttpRequestFactory())
                .baseUrl(baseUri)
                .build();
    }

}
