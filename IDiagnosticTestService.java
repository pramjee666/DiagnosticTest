package com.demo.rest.service;

import java.util.List;

import com.demo.rest.entity.DiagnosticTest;
import com.demo.rest.exception.DiagnosticTestNotFoundException;

public interface IDiagnosticTestService {

	List<DiagnosticTest> getAllDiagnosticTests();
	DiagnosticTest getDiagnosticTestById(int id) throws DiagnosticTestNotFoundException;
	DiagnosticTest addDiagnosticTest(DiagnosticTest diagnosticTest);
	DiagnosticTest updateDiagnosticTest(int id, DiagnosticTest diagnosticTest);
	DiagnosticTest deleteDiagnosticTestById(int id);

}
