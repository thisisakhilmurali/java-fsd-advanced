package com.example.appointmentservice.service;

import com.example.appointmentservice.repository.AppointmentRepository;
import com.example.appointmentservice.controller.DoctorConsumer;
import com.example.appointmentservice.controller.PatientConsumer;
import com.example.appointmentservice.entity.Appointment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class AppointmentService {

    @Autowired
    private DoctorConsumer doctorConsumer;

    @Autowired
    private PatientConsumer patientConsumer;

    @Autowired
    private AppointmentRepository appointmentRepository;

    public String bookAnAppointment(Appointment appointment) {

        Long idOfDoctorFromDatabase = Objects.requireNonNull(doctorConsumer.getDoctorById(appointment.getDoctorId()).getBody()).getId();
        Long idOfPatientFromDatabase = Objects.requireNonNull(patientConsumer.getPatientById(appointment.getPatientId()).getBody()).getId();

        String message = "Failed to book the Appointment. Please check your details";

        if(Objects.equals(idOfDoctorFromDatabase, appointment.getDoctorId()) && Objects.equals(idOfPatientFromDatabase, appointment.getPatientId())) {

            String nameOfDoctor = Objects.requireNonNull(doctorConsumer.getDoctorById(appointment.getDoctorId()).getBody()).getName();
            String date = appointment.getDate();
            String time = appointment.getTime();
            String tokenNumber = String.valueOf(appointment.getId());

            appointmentRepository.save(appointment);

            message = "Booking Successful.\n Appointment with Dr. " + nameOfDoctor + " on " + date + " at " + time;

        }

        return message;

    }

    public List<Appointment> getAppointmentsForDoctor(Long doctorId) {
        return appointmentRepository.findAllByDoctorId(doctorId);
    }

    public List<Appointment> getAppointmentsForPatient(Long patientId) {
        return appointmentRepository.findAllByPatientId(patientId);
    }

    public String deleteAnAppointment(Long id) {
        Optional<Appointment> optionalAppointment = appointmentRepository.findById(id);
        if(optionalAppointment.isPresent()) {
            appointmentRepository.delete(optionalAppointment.get());
            return "Appointment for token number " + optionalAppointment.get().getId() + " deleted.";
        }
        return "Deletion Failed! No Appointments found";
    }

}
