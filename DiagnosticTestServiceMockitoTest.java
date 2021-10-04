package com.demo.rest.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.demo.rest.dao.IDiagnosticTestDao;
import com.demo.rest.entity.DiagnosticTest;
import com.demo.rest.exception.DiagnosticTestNotFoundException;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
public class DiagnosticTestServiceMockitoTest {
	
	@InjectMocks
	DiagnosticTestServiceImpl diagnosticTestService;
	
	@MockBean
	IDiagnosticTestDao diagnostictestDao;
	
	
	@BeforeEach
	void init() {
		MockitoAnnotations.openMocks(this);
	}
	
	@Test
	void testGetDiagnosticTestById() throws DiagnosticTestNotFoundException {
		
		DiagnosticTest diagnosticTest = new DiagnosticTest(122, "Urine Test", 1999.988, "normal", "seventh");
		Mockito.when(diagnostictestDao.findById(122)).thenReturn(Optional.of(diagnosticTest));
		DiagnosticTest dgt= diagnosticTestService.getDiagnosticTestById(122);
		assertEquals(122, dgt.getId());
		assertEquals("Urine Test", dgt.getTestName());
	
	}
	
	@Test
	void testGetAllDiagnosticTests() {
		DiagnosticTest dgt1 = new DiagnosticTest(122, "Urine Test", 1999.988, "normal", "seventh");
		//DiagnosticTest dgt2 = new DiagnosticTest(123, "mental checkup", 3333.3333, "high", "eighth");
		List<DiagnosticTest> diagnosticTestList = new ArrayList<>();
		diagnosticTestList.add(dgt1);
		//diagnosticTestList.add(dgt2);
		Mockito.when(diagnostictestDao.findAll()).thenReturn(diagnosticTestList);
		List<DiagnosticTest> diagnosticTest = diagnosticTestService.getAllDiagnosticTests();
		assertEquals(1, diagnosticTest.size());
		assertEquals(122, diagnosticTest.get(0).getId());
		assertEquals("Urine Test", diagnosticTest.get(0).getTestName());
		assertEquals(1999.988, diagnosticTest.get(0).getTestPrice());
		assertEquals("normal", diagnosticTest.get(0).getNormalValue());
		assertEquals("seventh", diagnosticTest.get(0).getUnits());
//		assertEquals(123, diagnosticTest.get(1).getId());
//		assertEquals("mental checkup", diagnosticTest.get(0).getTestName());
//		assertEquals(3333.3333, diagnosticTest.get(0).getTestPrice());
//		assertEquals("high", diagnosticTest.get(0).getNormalValue());
//		assertEquals("eighth", diagnosticTest.get(0).getUnits());
	}
	
	@Test
	void testaddDiagnosticTest() {
		DiagnosticTest diagnosticTest = new DiagnosticTest(119, "Urine Test", 1999.988, "normal", "seventh");
		Mockito.when(diagnostictestDao.save(diagnosticTest)).thenReturn(diagnosticTest);
		DiagnosticTest newDiagnosticTest = diagnosticTestService.addDiagnosticTest(diagnosticTest);
		assertEquals(119, newDiagnosticTest.getId());
		assertEquals("Urine Test", newDiagnosticTest.getTestName());
	}
	
	@Test
	void testUpdateDiagnosticTest() {
		DiagnosticTest diagnosticTest = new DiagnosticTest(118, "Urine Test", 1999.988, "normal", "seventh");
		Mockito.when(diagnostictestDao.findById(118)).thenReturn(Optional.of(diagnosticTest));
		Mockito.when(diagnostictestDao.save(diagnosticTest)).thenReturn(diagnosticTest);
		DiagnosticTest updatedDiagnosticTest = diagnosticTestService.updateDiagnosticTest(118, diagnosticTest);
		assertEquals("Urine Test", updatedDiagnosticTest.getTestName());
	}
	
	@Test
	void testDeleteDiagnosticTest() {
		DiagnosticTest diagnosticTest = new DiagnosticTest(118, "Urine Test", 1999.988, "normal", "seventh");
		Mockito.when(diagnostictestDao.findById(118)).thenReturn(Optional.of(diagnosticTest));
		diagnostictestDao.deleteById(1024);
		DiagnosticTest dgt = diagnosticTestService.deleteDiagnosticTestById(118);
		assertEquals("Urine Test", dgt.getTestName());
	}
	
	
}
