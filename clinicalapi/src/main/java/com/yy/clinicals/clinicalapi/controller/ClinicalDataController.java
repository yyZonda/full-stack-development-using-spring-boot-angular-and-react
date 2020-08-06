package com.yy.clinicals.clinicalapi.controller;

import com.yy.clinicals.clinicalapi.Entity.ClinicalData;
import com.yy.clinicals.clinicalapi.Entity.Patient;
import com.yy.clinicals.clinicalapi.dto.ClinicalDataRequest;
import com.yy.clinicals.clinicalapi.repos.ClinicalDataRepository;
import com.yy.clinicals.clinicalapi.repos.PatientRepository;
import com.yy.clinicals.clinicalapi.util.BMICalculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
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

    @RequestMapping(value = "/clinicals/{patientId}/{componentName}",method = RequestMethod.GET)
    public List<ClinicalData> getClinicalData(@PathVariable("patientId") int patientId, @PathVariable("componentName")String componentName){
        if(componentName.equals("bmi")){
            componentName = "hw";
        }
        List<ClinicalData> clinicalData = clinicalDataRepository.findByPatientIdAndComponentNameOrderByMeasuredDateTime(patientId,componentName);
        List<ClinicalData> duplicateClinicaData = new ArrayList<>(clinicalData);
        for(ClinicalData eachEntry : duplicateClinicaData){
            BMICalculator.calculateBMI(clinicalData, eachEntry);
        }
        return clinicalData;
    }
}
