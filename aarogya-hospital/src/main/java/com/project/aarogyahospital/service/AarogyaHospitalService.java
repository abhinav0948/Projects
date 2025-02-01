package com.project.aarogyahospital.service;

import com.project.aarogyahospital.entity.AarogyaHospital;
import com.project.aarogyahospital.entity.RecoveryStatus;
import com.project.aarogyahospital.repository.AarogyaHospitalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AarogyaHospitalService {

    @Autowired
    private AarogyaHospitalRepository aarogyaHospitalRepository;

    public AarogyaHospital addPatient(AarogyaHospital aarogyaHospital) {
        return aarogyaHospitalRepository.save(aarogyaHospital);
    }

    public List<AarogyaHospital> getAllPatients() {
        return aarogyaHospitalRepository.findAll();
    }

    public AarogyaHospital getById(Long id) {
        return aarogyaHospitalRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Patient with the enetered ID not found"));
    }

    public String deletePatientById(long id) {
        aarogyaHospitalRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Patient with the enetered ID not found"));
        aarogyaHospitalRepository.deleteById(id);
        return "Successfully deleted Patient details with the entered ID" + id;
    }

    public AarogyaHospital updatePatient(Long id, AarogyaHospital updatedPatient) {
        AarogyaHospital existingPatient = aarogyaHospitalRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Patient with the enetered ID not found"));

        if (updatedPatient != null) {
            existingPatient.setPatientName(updatedPatient.getPatientName());
            existingPatient.setGender(updatedPatient.getGender());
            existingPatient.setPatientNumber(updatedPatient.getPatientNumber());
            existingPatient.setPatientAddress(updatedPatient.getPatientAddress());
            existingPatient.setGuardianName(updatedPatient.getGuardianName());
            existingPatient.setGuardianNumber(updatedPatient.getGuardianNumber());
            existingPatient.setGuardianAddress(updatedPatient.getGuardianAddress());
        }
        return aarogyaHospitalRepository.save(existingPatient);
    }

    public List<AarogyaHospital> getBygender(String gender) {
        return aarogyaHospitalRepository.findByGender(gender);
    }

    public AarogyaHospital updateRecoveryStatus(Long id, RecoveryStatus recoveryStatus) {

        AarogyaHospital existingPatient = aarogyaHospitalRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Patient not found with id : " + id));

        existingPatient.setRecoveryStatus(recoveryStatus);
        return aarogyaHospitalRepository.save(existingPatient);

    }


}
