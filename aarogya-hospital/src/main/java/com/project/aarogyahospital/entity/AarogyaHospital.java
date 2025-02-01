package com.project.aarogyahospital.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "patient_details")
@Data
public class AarogyaHospital {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String patientName;
    private String gender;
    private String patientNumber;
    private String patientAddress;
    private String guardianName;
    private String guardianNumber;
    private String guardianAddress;

    @Enumerated(EnumType.STRING)
    private RecoveryStatus recoveryStatus;

    public AarogyaHospital() {
        this.recoveryStatus = RecoveryStatus.NOT_RECOVERED;
    }
}

