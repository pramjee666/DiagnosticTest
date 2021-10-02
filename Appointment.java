package com.demo.rest.entity;

import java.time.LocalDate;
//import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Data;



@Entity
@Data
public class Appointment {
	
	@Id
	@GeneratedValue
	private int appid;
	private LocalDate appointmentDate;
	private String approvalStatus;
	//private LocalTime appointmentTime;
	
	
	
   

    @OneToMany(targetEntity=DiagnosticTest.class, mappedBy="appointment")
    private List<DiagnosticTest> diagnosticTest = new ArrayList<>();

}
