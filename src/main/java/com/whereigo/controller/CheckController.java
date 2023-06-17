package com.whereigo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.whereigo.model.ApiResponse;

@RestController
@CrossOrigin
@RequestMapping("check")
public class CheckController {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @GetMapping(value = "/serverStatus", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse> getServerStatus() {
        log.info("/check/serverStatus");
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setMessage("server is alive");
        apiResponse.setStatusCode(200);
        return ResponseEntity.ok().body(apiResponse);
    }
}
