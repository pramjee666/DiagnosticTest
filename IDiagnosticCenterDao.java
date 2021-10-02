package com.demo.rest.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.rest.entity.DiagnosticCenter;

public interface IDiagnosticCenterDao extends JpaRepository<DiagnosticCenter, Integer> {

}
