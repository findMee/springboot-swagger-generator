package com.example.springbootswaggercrud.sampleData;

import java.io.IOException;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

public class PopulateSwaggerData {

    public static void main(String[] args) {
        PopulateSwaggerData swaggerData = new PopulateSwaggerData();
        swaggerData.start();
    }

    private void start() {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();
        HttpEntity requestEntity = new HttpEntity<>(httpHeaders);

        //getSpringData(wmRestTemplate, "https://springboot-swaggercrud.herokuapp.com/employees", requestEntity);
        for (int i = 100; i < 110; i++) {
            getSpringData(i, restTemplate, "https://randomuser.me/api?format=json", requestEntity);
        }
    }

    private void getSpringData(int index, RestTemplate restTemplate, String url, HttpEntity requestEntity) {
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, requestEntity, String.class);
        String body = response.getBody();
        ResponseData response1 = null;
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            response1 = objectMapper.readValue(body, ResponseData.class);
        } catch (IOException e) {
            System.out.println("Exception" + e);
        }

        response1.getResults().get(0).setEmpId(String.valueOf(index));
        postToSpringBootApp(restTemplate, response1.getResults().get(0));
    }

    private void postToSpringBootApp(RestTemplate restTemplate, Employee employee) {
        HttpHeaders httpHeaders = new HttpHeaders();
        HttpEntity requestEntity = new HttpEntity<>(employee, httpHeaders);
        ResponseEntity<String> localHostResponse = restTemplate.exchange("http://localhost:8080/employees", HttpMethod.POST, requestEntity, String.class);
        //ResponseEntity<String> herokuResponse = restTemplate.exchange("https://springboot-swaggercrud.herokuapp.com/employees", HttpMethod.POST, requestEntity, String.class);
        System.out.println(localHostResponse);
    }
}
