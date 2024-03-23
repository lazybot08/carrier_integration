package com.godash.CarrierIntegration.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ShipmentAPIClient {

    private static final Logger logger = LoggerFactory.getLogger(ShipmentAPIClient.class);

    private final RestTemplate restTemplate;

    public ShipmentAPIClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public void createShipment(String endpoint, String origin, String destination, String packageDetails, String weight, String apiToken) {
        // Construct request payload
        String payload = "{\"origin\": \"" + origin + "\", \"destination\": \"" + destination + "\", \"package\": \"" + packageDetails + "\", \"weight\": \"" + weight + "\"}";

        // Set request headers
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + apiToken);
        headers.setContentType(MediaType.APPLICATION_JSON);

        // Create HTTP entity with payload and headers
        HttpEntity<String> requestEntity = new HttpEntity<>(payload, headers);

        // Make POST request
        ResponseEntity<String> responseEntity = restTemplate.postForEntity(endpoint, requestEntity, String.class);

        // Handle response
        if (responseEntity.getStatusCode() == HttpStatus.OK) {
            String responseBody = responseEntity.getBody();
            // Process the response body...
            logger.info("Shipment created successfully. Response: {}", responseBody);
        } else {
            // Handle error response...
            logger.error("Error creating shipment. Status code: {}", responseEntity.getStatusCode());
        }
    }
}
