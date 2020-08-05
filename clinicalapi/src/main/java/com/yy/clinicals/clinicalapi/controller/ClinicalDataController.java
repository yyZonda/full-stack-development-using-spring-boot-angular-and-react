package com.yy.clinicals.clinicalapi.controller;

import com.yy.clinicals.clinicalapi.Entity.ClinicalData;
import com.yy.clinicals.clinicalapi.Entity.Patient;
import com.yy.clinicals.clinicalapi.dto.ClinicalDataRequest;
import com.yy.clinicals.clinicalapi.repos.ClinicalDataRepository;
import com.yy.clinicals.clinicalapi.repos.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ClinicalDataController {

    @Autowired
    ClinicalDataRepository clinicalDataRepository;

    @Autowired
    PatientRepository patientRepository;

    @RequestMapping(value = "/clinicals",method = RequestMethod.POST)
    public ClinicalData saveClinicalData(@RequestBody ClinicalDataRequest request){
        Patient patient = patientRepository.findById(request.getPatientId()).get();
        ClinicalData clinicalData = new ClinicalData();
        clinicalData.setComponentName(request.getComponentName());
        clinicalData.setComponentValue((request.getComponentValue()));
        clinicalData.setPatient(patient);
        return clinicalDataRepository.save(clinicalData);
    }
}
