package com.yy.clinicals.clinicalapi.repos;

import com.yy.clinicals.clinicalapi.Entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient,Integer> {
}
