package com.demo.rest.service;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.demo.rest.entity.Appointment;
import com.demo.rest.entity.DiagnosticCenter;
import com.demo.rest.entity.DiagnosticTest;


@SpringBootTest
public class DiagnosticTestServiceTest {
	@Autowired
	IDiagnosticTestService diagnostictestService;
	
	@Test
	@Disabled
	void testgetAllDiagnosticTests() {
		List<DiagnosticTest> diagnosticTest = diagnostictestService.getAllDiagnosticTests();
		assertEquals(7, diagnosticTest.size());
		assertEquals("Blood Test", diagnosticTest.get(0).getTestName());
	}
	
	@Test
	@Disabled
	void testaddDiagbnosticTest() {
		DiagnosticTest diagnosticTest = new DiagnosticTest(118, "mental test", 999.988, "normal", "sixth"); 
		DiagnosticTest newDiagnosticTest = diagnostictestService.addDiagnosticTest(diagnosticTest);
		assertEquals(118, newDiagnosticTest.getId());
		assertEquals("mental test", newDiagnosticTest.getTestName());
		
	}
	
	

	@Test
	@Disabled
	void testdeleteDiagnosticTestById() {
		DiagnosticTest diagnosticTest = diagnostictestService.deleteDiagnosticTestById(117);
		assertEquals("mental test", diagnosticTest.getTestName());
	}
	

}
