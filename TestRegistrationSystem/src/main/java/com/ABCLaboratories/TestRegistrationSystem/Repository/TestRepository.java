package com.ABCLaboratories.TestRegistrationSystem.Repository;

import com.ABCLaboratories.TestRegistrationSystem.model.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestRepository extends JpaRepository<Test,Integer> {
}
