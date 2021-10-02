package com.demo.rest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.rest.dao.IAppointmentDao;
import com.demo.rest.entity.Appointment;


@Service
public class AppointmentServiceImpl implements IAppointmentService {
	
	@Autowired
	IAppointmentDao appointmentDao;

	@Override
	public List<Appointment> getAllAppointments() {
	   return appointmentDao.findAll();
	}
	
	
    //
	@Override
	public Appointment addAppointment(Appointment appointment) {
		Optional<Appointment> apt =appointmentDao.findById(appointment.getAppid());
		return appointmentDao.save(appointment);
	}

	@Override
	public Appointment deleteAppointment(int appid) {
		Appointment apt = appointmentDao.findById(appid).get();
		appointmentDao.deleteById(appid);
		return apt;

	}

	@Override
	public Appointment updateAppointment(int appid, Appointment appointment) {
		Appointment apt = appointmentDao.findById(appid).get();
		apt.setAppointmentDate(appointment.getAppointmentDate());
		apt.setApprovalStatus(appointment.getApprovalStatus());
		//apt.setAppointmentTime(appointment.getAppointmentTime());
		return appointmentDao.save(apt) ;
	
	}

	@Override
	public Appointment getAppointmentByAppid(int appid) {
		Optional<Appointment> apt = appointmentDao.findById(appid);
		return apt.get();
	}

}
