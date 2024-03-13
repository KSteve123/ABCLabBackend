package com.ABCLaboratories.TestRegistrationSystem.Repository;

import com.ABCLaboratories.TestRegistrationSystem.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient,Integer> {
}
