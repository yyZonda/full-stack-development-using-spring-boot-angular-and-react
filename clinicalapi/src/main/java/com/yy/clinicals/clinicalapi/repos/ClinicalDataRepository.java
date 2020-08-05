package com.yy.clinicals.clinicalapi.repos;

import com.yy.clinicals.clinicalapi.Entity.ClinicalData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClinicalDataRepository extends JpaRepository<ClinicalData,Integer> {
}
