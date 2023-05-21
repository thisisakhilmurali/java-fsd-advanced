package com.example.doctorservice.controller;

import com.example.doctorservice.entity.Doctor;
import com.example.doctorservice.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    private DoctorRepository doctorRepository;

    // doctor registration
    @PostMapping("/register")
    public ResponseEntity<Doctor> registerDoctor(@RequestBody Doctor doctor) {
        return new ResponseEntity<>(doctorRepository.save(doctor), HttpStatus.CREATED);
    }

    // doctor update
    @PutMapping("/update/{id}")
    public ResponseEntity<Doctor> updateDoctor(@PathVariable Long id, @RequestBody Doctor doctor) {
        Optional<Doctor> doctorOptional = doctorRepository.findById(id);
        if(doctorOptional.isPresent()) {
            Doctor updatedDoctor = doctorOptional.get();
            updatedDoctor.setName(doctor.getName());
            updatedDoctor.setDepartment(doctor.getDepartment());
            updatedDoctor.setExperience(doctor.getExperience());
            return new ResponseEntity<>(doctorRepository.save(updatedDoctor), HttpStatus.CREATED);
        } else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // doctor retrieval
    @GetMapping("/get/{id}")
    public ResponseEntity<Doctor> getDoctorById(@PathVariable Long id) {
        Optional<Doctor> doctorOptional = doctorRepository.findById(id);
        if(doctorOptional.isPresent()) {
            return new ResponseEntity<>(doctorOptional.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
