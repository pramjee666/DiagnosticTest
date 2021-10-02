package com.demo.rest.service;

import java.util.List;



import com.demo.rest.entity.DiagnosticCenter;

public interface IDiagnosticCenterService {

	List<DiagnosticCenter> getAllDiagnosticCenters();
	DiagnosticCenter getDiagnosticCenterById(int cid);
	DiagnosticCenter addDiagnosticCenter(DiagnosticCenter diagnosticCenter);
	DiagnosticCenter deleteDiagnosticCenterById(int cid);
	DiagnosticCenter updateDiagnosticCenter(int cid, DiagnosticCenter diagnosticCenter);

}
