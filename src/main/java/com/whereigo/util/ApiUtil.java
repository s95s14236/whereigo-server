package com.whereigo.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

public class ApiUtil {
    static Logger log = LogManager.getLogger();

    public static <T> T send(String url, HttpMethod method, Class<T> t) {
        try {
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<String> httpEntity = new HttpEntity<String>(httpHeaders);

            ResponseEntity<T> responseEntity = restTemplate.exchange(url, method, httpEntity, t);
            T result = responseEntity.getBody();
            log.info(responseEntity.getStatusCode());
            return result;
        } catch (HttpClientErrorException httpClientErrorException) {
            log.error(httpClientErrorException.getResponseBodyAsString());
            return null;
        } catch (Exception e) {
            log.error(e.getMessage());
            return null;
        }
    }
}
