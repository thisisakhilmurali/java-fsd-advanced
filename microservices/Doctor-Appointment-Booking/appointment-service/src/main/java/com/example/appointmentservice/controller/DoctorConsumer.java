package com.example.appointmentservice.controller;

import com.example.appointmentservice.entity.Doctor;
import com.example.appointmentservice.entity.Patient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "DOCTOR-SERVICE")
public interface DoctorConsumer {

    @GetMapping("/doctor/get/{id}")
    public ResponseEntity<Doctor> getDoctorById(@PathVariable Long id);

}
