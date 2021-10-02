package com.demo.rest.entity;


import javax.persistence.CascadeType;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

//import org.apache.logging.log4j.message.Message;

//import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class DiagnosticTest {
	
		
		//fields
	    @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
		private int id;
	    @Column(name="testname")
		private String testName;
		private double testPrice;
		//@Column(name="normalvalue")
		private String normalValue;
		private String units;
		
		//@JsonIgnore
	    @ManyToOne(cascade= CascadeType.PERSIST)
	    @JoinColumn(name="Apptm_fk")
        private Appointment appointment;
		
		//@JsonIgnore
		@ManyToOne(cascade=CascadeType.PERSIST)
		@JoinColumn(name="diagno_center_fk")
		private DiagnosticCenter diagnosticCenter;

		
		public DiagnosticTest() {
			
		}
		
		//constructor
		public DiagnosticTest(int id, String testName, double testPrice, String normalValue, String units) {
			super();
			this.id = id;
			this.testName = testName;
			this.testPrice = testPrice;
			this.normalValue = normalValue;
			this.units = units;
		}
		
		//getter and setter
		

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getTestName() {
			return testName;
		}

		public void setTestName(String testName) {
			this.testName = testName;
		}

		public double getTestPrice() {
			return testPrice;
		}

		public void setTestPrice(double testPrice) {
			this.testPrice = testPrice;
		}

		public String getNormalValue() {
			return normalValue;
		}

		public void setNormalValue(String normalValue) {
			this.normalValue = normalValue;
		}

		public String getUnits() {
			return units;
		}

		public void setUnits(String units) {
			this.units = units;
		}
		
	   public DiagnosticCenter getDiagnosticCenter() {
			return diagnosticCenter;
		}

		public void setDiagnosticCenter(DiagnosticCenter diagnosticCenter) {
			this.diagnosticCenter = diagnosticCenter;
		}
		
		
		
		
public Appointment getAppointment() {
			return appointment;
		}

		public void setAppointment(Appointment appointment) {
			this.appointment = appointment;
		}
        
		//toString
		@Override
		public String toString() {
			return "DiagnosticTest [id=" + id + ", testName=" + testName + ", testPrice=" + testPrice + ", normalValue="
					+ normalValue + ", units=" + units + ", appointment=" + appointment + ", diagnosticCenter="
					+ diagnosticCenter + "]";
		}

		
		
	    
	
		
		
		
		
}



