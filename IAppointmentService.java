package com.demo.rest.service;

import java.util.List;

import com.demo.rest.entity.Appointment;

public interface IAppointmentService {
	
	List<Appointment> getAllAppointments();
	Appointment addAppointment(Appointment appointment);
	Appointment deleteAppointment(int appid);
	Appointment updateAppointment(int appid, Appointment appointment);
	Appointment getAppointmentByAppid(int appid);
	
	
	
	

}
