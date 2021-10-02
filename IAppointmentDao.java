package com.demo.rest.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.rest.entity.Appointment;

@Repository
public interface IAppointmentDao extends JpaRepository<Appointment, Integer> {

}
