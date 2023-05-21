package com.example.appointmentservice.controller;

import com.example.appointmentservice.entity.Appointment;
import com.example.appointmentservice.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    // Book an appointment
    @PostMapping("/book")
    public String bookAnAppointment(@RequestBody Appointment appointment) {
        return appointmentService.bookAnAppointment(appointment);
    }

    // Retrieve an appointment for doctor
    @GetMapping("/get/doctor/{doctorId}")
    public List<Appointment> getAppointmentsForDoctor(@PathVariable Long doctorId) {
        return appointmentService.getAppointmentsForDoctor(doctorId);
    }

    // Retrieve an appointment for patient
    @GetMapping("/get/patient/{patientId}")
    public List<Appointment> getAppointmentsForPatient(@PathVariable Long patientId) {
        return appointmentService.getAppointmentsForPatient(patientId);
    }

    // Delete an appointment
    @DeleteMapping("/delete/{id}")
    public String deleteAnAppointment(@PathVariable Long id) {
        return appointmentService.deleteAnAppointment(id);
    }

}
