package com.demo.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.rest.entity.Appointment;
import com.demo.rest.service.IAppointmentService;

@RestController
public class AppointmentController {
	
	@Autowired
	IAppointmentService appointmentService;
	
	@GetMapping("/appointments")
	ResponseEntity<List<Appointment>> getAllAppointment() {
		return new ResponseEntity<>(appointmentService.getAllAppointments(), HttpStatus.OK);
		
	}
	
	@PostMapping("/appointments")
	ResponseEntity<Appointment> addAppointment(@RequestBody Appointment appointment) {
		Appointment apt = appointmentService.addAppointment(appointment);
		return new ResponseEntity<>(apt, HttpStatus.CREATED); 
	
	}
	//update by id
	@PutMapping("/appointments/{appid}")
	ResponseEntity<Appointment> updateAppointment(@PathVariable("appid") int Appid, @RequestBody Appointment appointment) {
	 Appointment apt = appointmentService.updateAppointment(Appid, appointment);
	 return new ResponseEntity<>(apt, HttpStatus.OK);
   }
	
	//delete method
	@DeleteMapping("/appointments/{appid}")
	ResponseEntity<Appointment> deleteAppointment(@PathVariable("appid") int Appid,@RequestBody Appointment appointment) {
		Appointment apt= appointmentService.deleteAppointment(Appid);
		return new ResponseEntity<>(apt, HttpStatus.OK);
	}
	@GetMapping("/appointments/appid/{appid}")
	ResponseEntity<Appointment> getAppointmentByAppid(@PathVariable("appid") int Appid) {
	 Appointment app = appointmentService.getAppointmentByAppid(Appid);
	 return new ResponseEntity<>(app, HttpStatus.OK); // 200 Ok
	}
	
	

}
