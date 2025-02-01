package com.project.aarogyahospital.controller;

import com.project.aarogyahospital.entity.AarogyaHospital;
import com.project.aarogyahospital.entity.RecoveryStatus;
import com.project.aarogyahospital.service.AarogyaHospitalService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/aarogyahospital")
public class AarogyaHospitalController {

    @Autowired
    private AarogyaHospitalService aarogyaHospitalService;

    // Controller method to add patient
    @PostMapping("/addPatient")
    public AarogyaHospital addPatient(@RequestBody AarogyaHospital aarogyaHospital) {
        return aarogyaHospitalService.addPatient(aarogyaHospital);
    }

    // Controller method to get all patients
    @GetMapping("/allPatients")
    public List<AarogyaHospital> getAllPAtients() {
        return aarogyaHospitalService.getAllPatients();
    }

    //Controller method for get patient by id
    @GetMapping("patient/{id}")
    public AarogyaHospital getById(@PathVariable Long id) {
        return aarogyaHospitalService.getById(id);
    }

    //Controller method to delete patient by id
    @DeleteMapping("/deletePatient/{id}")
    public String deletePatientById(@PathVariable long id) {
        return aarogyaHospitalService.deletePatientById(id);
    }

    //Controller method to update patient by id
    @PutMapping("/{id}")
    public AarogyaHospital updatePatient(@PathVariable Long id, @RequestBody AarogyaHospital updatedPatient) {
        return aarogyaHospitalService.updatePatient(id, updatedPatient);
    }

    //Controller method to get patient by gender
    @GetMapping("patients/{gender}")
    public List<AarogyaHospital> getByGender(@PathVariable String gender) {
        return aarogyaHospitalService.getBygender(gender);
    }

    //Controller method to update patient recovery status
    @PutMapping("/updateRecoveryStatus/{id}")
    public AarogyaHospital updateRecoveryStatus(@PathVariable Long id, @RequestBody @NotNull Map<String, String> requestBody) {
        String recoveryStatusValue = requestBody.get("recoveryStatus");
        RecoveryStatus recoveryStatus = RecoveryStatus.valueOf(recoveryStatusValue);
        return aarogyaHospitalService.updateRecoveryStatus(id, recoveryStatus);
    }

}
