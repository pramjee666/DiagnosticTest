package com.demo.rest.service;

import java.util.List;
import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.rest.dao.IDiagnosticCenterDao;
import com.demo.rest.entity.DiagnosticCenter;

@Service
public class DiagnosticCenterServiceImpl implements IDiagnosticCenterService {
	
	@Autowired
	IDiagnosticCenterDao diagnosticCenterDao;

	@Override
	public List<DiagnosticCenter> getAllDiagnosticCenters() {
		return diagnosticCenterDao.findAll();
		
	}

	@Override
	public DiagnosticCenter getDiagnosticCenterById(int cid) {
		Optional<DiagnosticCenter> diagnosticCenter = diagnosticCenterDao.findById(cid);
		return diagnosticCenter.get();
	}

	@Override
	public DiagnosticCenter addDiagnosticCenter(DiagnosticCenter diagnosticCenter) {
		Optional<DiagnosticCenter> dgc = diagnosticCenterDao.findById(diagnosticCenter.getCid());
		return diagnosticCenterDao.save(diagnosticCenter);
	}

	@Override
	public DiagnosticCenter deleteDiagnosticCenterById(int cid) {
		DiagnosticCenter dgc = diagnosticCenterDao.findById(cid).get();
		diagnosticCenterDao.deleteById(cid);
		return dgc;
		
	}

	@Override
	public DiagnosticCenter updateDiagnosticCenter(int cid, DiagnosticCenter diagnosticCenter) {
		
		DiagnosticCenter dgc = diagnosticCenterDao.findById(cid).get();
		dgc.setName(diagnosticCenter.getName());
		dgc.setAddress(diagnosticCenter.getAddress());
		dgc.setContactNo(diagnosticCenter.getContactNo());
		dgc.setContactEmail(diagnosticCenter.getContactEmail());
		return diagnosticCenterDao.save(dgc);
	}

}
