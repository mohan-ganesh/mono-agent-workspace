package com.example.appointment.apptapi.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;


@RestController
public class DefaultController {

    public static Log logger = LogFactory.getLog(DefaultController.class);

    /**
     *
     * @return String
     */
    @GetMapping(path = "/healthcheck")
    public ResponseEntity<String> healthcheck() {

        return ResponseEntity.ok("alive...");

    }


}