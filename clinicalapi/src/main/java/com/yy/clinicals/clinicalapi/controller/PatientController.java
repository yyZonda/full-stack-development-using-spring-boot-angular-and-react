package com.yy.clinicals.clinicalapi.controller;

import com.yy.clinicals.clinicalapi.Entity.Patient;
import com.yy.clinicals.clinicalapi.repos.ClinicalDataRepository;
import com.yy.clinicals.clinicalapi.repos.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PatientController {

    @Autowired
    PatientRepository patientRepository;

    @Autowired
    ClinicalDataRepository clinicalDataRepository;

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
}
