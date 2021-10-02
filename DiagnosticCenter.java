package com.demo.rest.entity;




import java.util.ArrayList;
import java.util.List;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;




import lombok.Data;

@Entity
@Data
public class DiagnosticCenter {
	
	
	@Id
	@GeneratedValue
	private int cid;
	private String name;
	private String contactNo;
	private String address;
	private String contactEmail;
	
	
   
	
    @OneToMany(targetEntity=DiagnosticTest.class, mappedBy="diagnosticCenter")
	private List<DiagnosticTest> diagnosticTest = new ArrayList<>();
	
	
	
}
