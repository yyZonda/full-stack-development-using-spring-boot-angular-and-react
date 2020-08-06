package com.yy.clinicals.clinicalapi.repos;

import com.yy.clinicals.clinicalapi.Entity.ClinicalData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClinicalDataRepository extends JpaRepository<ClinicalData,Integer> {
    List<ClinicalData> findByPatientIdAndComponentNameOrderByMeasuredDateTime(int patinetId,String componentName);
}
