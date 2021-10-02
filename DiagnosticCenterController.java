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

import com.demo.rest.entity.DiagnosticCenter;
import com.demo.rest.service.IDiagnosticCenterService;

@RestController
public class DiagnosticCenterController {
	
	  @Autowired
	  IDiagnosticCenterService diagnosticCenterService;
	
	
	     //Get all Centers - get
	    @GetMapping("/diagnosticcenters")
	    ResponseEntity<List<DiagnosticCenter>>getAllDiagnosticCenters(){
	    return new ResponseEntity<>(diagnosticCenterService.getAllDiagnosticCenters(), HttpStatus.OK);
	  }
	
	
	//get diagnostic center by id
		@GetMapping("/diagnosticcenters/cid/{cid}")	
		ResponseEntity<DiagnosticCenter> getDiagnosticCenterById(@PathVariable("cid") int cid) {
			DiagnosticCenter diagnosticCenter = diagnosticCenterService.getDiagnosticCenterById(cid);
			return new ResponseEntity<>(diagnosticCenter, HttpStatus.OK);
		}
		
		// add diagnostic center 
		@PostMapping("/diagnosticcenters")
		 ResponseEntity<DiagnosticCenter> addDiagnosticCenter(@RequestBody DiagnosticCenter diagnosticCenter) {
			//logger.info(diagnosticCenter);
			DiagnosticCenter dgc = diagnosticCenterService.addDiagnosticCenter( diagnosticCenter);
				return new ResponseEntity<>(dgc, HttpStatus.CREATED);
		}
		
		//delete diagnostic center by id
		@DeleteMapping("/diagnosticcenters/{cid}")
		ResponseEntity <DiagnosticCenter> deleteDiagnosticCenterById(@PathVariable("cid") int cid) {
		DiagnosticCenter diagnosticCenter = diagnosticCenterService.deleteDiagnosticCenterById(cid);
		return new ResponseEntity<>(diagnosticCenter, HttpStatus.OK);
		}
		
		//update diagnostic center
		@PutMapping("/diagnosticcenters/{cid}")
		ResponseEntity <DiagnosticCenter> updateDiagnosticCenter(@PathVariable ("cid") int cid, @RequestBody DiagnosticCenter diagnosticCenter) {
		DiagnosticCenter dgc = diagnosticCenterService.updateDiagnosticCenter(cid, diagnosticCenter);
		return new ResponseEntity<>(dgc, HttpStatus.OK);
		}

}
