package com.example.appointment.apptapi.controller;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import com.example.appointment.apptapi.api.AppointmentApi;

import com.example.appointment.apptapi.pojo.AppointmentRequest;
import com.example.appointment.apptapi.pojo.AppointmentSchedule;

import org.springframework.http.*;

@RestController
public class AppointmentController {

    public static Log logger = LogFactory.getLog(AppointmentController.class);

    @Autowired
    AppointmentApi appointmentApi;

    /**
     *
     * @return String
     */
    @GetMapping(path = "/dayandtime", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<AppointmentSchedule>> getAppointmentSlots() {

        return ResponseEntity.ok(appointmentApi.getAppointmentSlots());

    }

    /**
     * 
     * @param appointmentRequest
     * @return
     */
    @PostMapping(path = "/confirm", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> createAppointment(@RequestBody AppointmentRequest appointmentRequest) {

        AppointmentRequest docRef = appointmentApi.confirmAppointment(appointmentRequest);
        return ResponseEntity.ok(docRef.getComments());

    }

}