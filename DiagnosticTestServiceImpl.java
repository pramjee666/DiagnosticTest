package com.demo.rest.service;

import java.util.List;
import java.util.Optional;

//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.rest.dao.IDiagnosticTestDao;
//import com.demo.rest.entity.Appointment;
import com.demo.rest.entity.DiagnosticTest;
import com.demo.rest.exception.DiagnosticTestFoundException;
import com.demo.rest.exception.DiagnosticTestNotFoundException;

@Service
public class DiagnosticTestServiceImpl implements IDiagnosticTestService {
	
	
	@Autowired
	IDiagnosticTestDao diagnostictestDao;
	
	//private static Logger logger =LogManager.getLogger();

	@Override
	public List<DiagnosticTest> getAllDiagnosticTests() {
		return diagnostictestDao.findAll();
	}

  	@Override
	public DiagnosticTest getDiagnosticTestById(int id) throws DiagnosticTestNotFoundException {
  		Optional<DiagnosticTest> diagnosticTest = diagnostictestDao.findById(id);
  		if(!diagnosticTest.isPresent()) {
  			throw new DiagnosticTestNotFoundException("Diagnostic Test Details Not Found with given ID "+id);
  		}
		return diagnosticTest.get();
	}

	@Override
	public DiagnosticTest addDiagnosticTest(DiagnosticTest diagnosticTest) {
		//logger.info(diagnosticTest.getDiagnosticCenter());
		Optional<DiagnosticTest> dgt = diagnostictestDao.findById(diagnosticTest.getId());
  		if(dgt.isPresent()) {
  			throw new DiagnosticTestFoundException("Diagnostic Test Details Already Exist with given ID "+diagnosticTest.getId());
  		}
		return diagnostictestDao.save(diagnosticTest);
	}
	

	@Override
	public DiagnosticTest updateDiagnosticTest(int id, DiagnosticTest diagnosticTest) {
		DiagnosticTest dgt = diagnostictestDao.findById(id).get();
		dgt.setTestName(diagnosticTest.getTestName());
		dgt.setTestPrice(diagnosticTest.getTestPrice());
		dgt.setNormalValue(diagnosticTest.getNormalValue());
		dgt.setUnits(diagnosticTest.getUnits());
		return diagnostictestDao.save(dgt);
		}

	@Override
	public DiagnosticTest deleteDiagnosticTestById(int id) {
		DiagnosticTest dgt = diagnostictestDao.findById(id).get();
		diagnostictestDao.deleteById(id);
		return dgt;
	}
	
}	
