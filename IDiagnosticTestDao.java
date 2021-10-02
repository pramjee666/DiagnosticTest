package com.demo.rest.dao;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.rest.entity.DiagnosticTest;

@Repository
public interface IDiagnosticTestDao extends JpaRepository<DiagnosticTest, Integer> {

}
