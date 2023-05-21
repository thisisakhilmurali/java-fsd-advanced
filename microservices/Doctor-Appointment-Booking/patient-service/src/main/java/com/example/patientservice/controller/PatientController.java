package com.example.patientservice.controller;

import com.example.patientservice.entity.Patient;
import com.example.patientservice.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    private PatientRepository patientRepository;

    // patient registration
    @PostMapping("/register")
    public ResponseEntity<Patient> registerPatient(@RequestBody Patient patient) {
        return new ResponseEntity<>(patientRepository.save(patient), HttpStatus.CREATED);
    }

    // patient update
    @PutMapping("/update/{id}")
    public ResponseEntity<Patient> updatePatient(@PathVariable Long id, @RequestBody Patient patient) {
        Optional<Patient> patientOptional = patientRepository.findById(id);
        if(patientOptional.isPresent()) {
            Patient updatedPatient = patientOptional.get();
            updatedPatient.setName(patient.getName());
            updatedPatient.setAge(patient.getAge());
            updatedPatient.setPhoneNumber(patient.getPhoneNumber());
            return new ResponseEntity<>(patientRepository.save(updatedPatient), HttpStatus.CREATED);
        } else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // patient retrieval
    @GetMapping("/get/{id}")
    public ResponseEntity<Patient> getPatientById(@PathVariable Long id) {
        Optional<Patient> patientOptional = patientRepository.findById(id);
        if(patientOptional.isPresent()) {
            return new ResponseEntity<>(patientOptional.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}
