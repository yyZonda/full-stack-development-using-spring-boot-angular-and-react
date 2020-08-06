package com.yy.clinicals.clinicalapi.controller;

import com.yy.clinicals.clinicalapi.Entity.ClinicalData;
import com.yy.clinicals.clinicalapi.Entity.Patient;
import com.yy.clinicals.clinicalapi.repos.ClinicalDataRepository;
import com.yy.clinicals.clinicalapi.repos.PatientRepository;
import com.yy.clinicals.clinicalapi.util.BMICalculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class PatientController {

    @Autowired
    PatientRepository patientRepository;

    @Autowired
    ClinicalDataRepository clinicalDataRepository;

    private Map<String,String> filters = new HashMap<>();

    @RequestMapping(value = "/patients",method = RequestMethod.GET)
    public List<Patient> getPatients(){
        return patientRepository.findAll();
    }

    @RequestMapping(value = "/patients/{id}",method = RequestMethod.GET)
    public Patient getPatient(@PathVariable("id") int id){
        return patientRepository.findById(id).get();
    }

    @RequestMapping(value = "/patients",method = RequestMethod.POST)
    public Patient savePatient(@RequestBody Patient patient){
        return patientRepository.save(patient);
    }

    @RequestMapping(value = "/patients/analyze/{id}",method = RequestMethod.GET)
    public Patient analyze(@PathVariable("id") int id){
        Patient patient = patientRepository.findById(id).get();
        List<ClinicalData> clinicalData = patient.getClinicalData();
        List<ClinicalData> tmp=new ArrayList<>(clinicalData);
        for(ClinicalData c:tmp) {
            if(filters.containsKey(c.getComponentName())){
                clinicalData.remove((c));
                continue;
            }else{
                filters.put(c.getComponentName(),null);
            }
            BMICalculator.calculateBMI(clinicalData, c);
        }
        filters.clear();
        return patient;
    }


}
