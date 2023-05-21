package com.example.appointmentservice.controller;

import com.example.appointmentservice.entity.Patient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "PATIENT-SERVICE")
public interface PatientConsumer {

    @GetMapping("/patient/get/{id}")
    public ResponseEntity<Patient> getPatientById(@PathVariable Long id);

}
