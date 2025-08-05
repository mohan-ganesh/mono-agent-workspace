package com.example.appointment.apptapi.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RestController;

import com.example.appointment.apptapi.api.EmailApi;

import com.example.appointment.apptapi.pojo.Email;

@RestController
public class EmailController {

    public static Log logger = LogFactory.getLog(EmailController.class);
    


    @Autowired
    EmailApi emailApi;

    @PostMapping(path = "/email",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> sendEmail(@RequestBody Email input) {
        
        logger.info("email() - " + input.toString());

        boolean status = emailApi.sendEmail(input);

        return ResponseEntity.ok(status);

    }

}
