package com.ABCLaboratories.TestRegistrationSystem.Repository;

import com.ABCLaboratories.TestRegistrationSystem.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor,Integer> {

}
