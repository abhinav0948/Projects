package com.project.aarogyahospital.repository;

import com.project.aarogyahospital.entity.AarogyaHospital;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AarogyaHospitalRepository extends JpaRepository<AarogyaHospital, Long> {

    List<AarogyaHospital> findByGender(String gender);

}
