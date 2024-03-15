package com.bsmlabs.restclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Service
public class DefaultUniversityDataService implements UniversityDataService {

    @Value("${universityEndpointUrl}")
    String baseUri;

    private final RestClientConfig restClientConfig;

    public DefaultUniversityDataService(RestClientConfig restClientConfig) {
        this.restClientConfig = restClientConfig;
    }

    /**
     * using RestClient static create method
     */
    @Override
    public List<UniversityDataResponse> getUniversityDetails(String countryName) {
        var uri = UriComponentsBuilder.fromHttpUrl(baseUri)
                .queryParam("country", countryName)
                .build()
                .toUri();

        return restClientConfig.restClient().get()
                .uri(uri)
                .retrieve()
                .onStatus(HttpStatusCode::is4xxClientError, (request, response) -> System.out.println(response.getStatusText()))
                .body(new ParameterizedTypeReference<>() {
                });

    }

    /**
     * Using RestClient Builder Pattern
     */
    @Override
    public List<UniversityDataResponse> getUniversityDataWithBuilder(String countryName) {
        var uri = UriComponentsBuilder.fromHttpUrl(baseUri)
                .queryParam("country", countryName)
                .build()
                .toUri();
        return restClientConfig.restClientBuilder().get()
                .uri(uri)
                .retrieve()
                .body(new ParameterizedTypeReference<>() {
                });
    }
}
