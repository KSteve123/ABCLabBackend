package com.ABCLaboratories.TestRegistrationSystem.Repository;

import com.ABCLaboratories.TestRegistrationSystem.model.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StaffRepository extends JpaRepository<Staff,Integer> {
}
