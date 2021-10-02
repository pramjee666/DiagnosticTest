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

import com.demo.rest.entity.DiagnosticTest;
import com.demo.rest.exception.DiagnosticTestNotFoundException;
import com.demo.rest.service.IDiagnosticTestService;

@RestController
public class DiagnosticTestController {
	
	@Autowired
	IDiagnosticTestService diagnostictestService;
	
	//Get all diagnostic tests - GET
		@GetMapping("/diagnostictests")
		ResponseEntity<List<DiagnosticTest>> getAllDiagnosticTests(){
			return new ResponseEntity<>(diagnostictestService.getAllDiagnosticTests(), HttpStatus.OK);
		}
		
		//Get diagnostic test by Id - GET
		@GetMapping("/diagnostictests/{id}")
		ResponseEntity<DiagnosticTest> getDiagnosticTestById(@PathVariable("id") int id) throws DiagnosticTestNotFoundException {
		DiagnosticTest diagnostictest = diagnostictestService.getDiagnosticTestById(id);
		return new ResponseEntity<>(diagnostictest, HttpStatus.OK);//200 ok
		}
		/*
		//Get diagnostic test by testName - GET
		DiagnosticTest getdiagnostictestBytestName(String testname) {}
		*/
		//Add new Diagnostic test Details - POST
		@PostMapping("/diagnostictests")
		ResponseEntity<DiagnosticTest> addDiagnosticTest(@RequestBody DiagnosticTest diagnosticTest) {
			DiagnosticTest dgt = diagnostictestService.addDiagnosticTest(diagnosticTest);
			return new ResponseEntity<>(dgt, HttpStatus.CREATED); //201 created
		}
		
		
		//delete diagnostic test by ID - DELETE
		@DeleteMapping("/diagnostictests/{id}")
		ResponseEntity<DiagnosticTest> deleteDiagnosticTestById(@PathVariable("id") int id) {
		DiagnosticTest diagnosticTest =	diagnostictestService.deleteDiagnosticTestById(id);
		return new ResponseEntity<>(diagnosticTest, HttpStatus.OK);
		}
		
		//Update diagnostic test - PUT
		@PutMapping("/diagnostictests/{id}")
		ResponseEntity<DiagnosticTest> updateDiagnosticTest(@PathVariable("id") int id, @RequestBody DiagnosticTest diagnosticTest) {
		DiagnosticTest dgt = diagnostictestService.updateDiagnosticTest(id, diagnosticTest);
		return new ResponseEntity<>(dgt, HttpStatus.OK);
		}
		/*
		//update diagnostic test testName - PATCH
		DiagnosticTest updateDiagnosticTesttestName(int id, String newtestname) {}
		
		
		//update diagnostic test units -PATCH
		DiagnosticTest updateDiagnosticTesttestUnits(int id, String newunits) {}
		*/


}
