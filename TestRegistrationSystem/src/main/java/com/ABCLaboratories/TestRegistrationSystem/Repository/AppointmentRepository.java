package com.ABCLaboratories.TestRegistrationSystem.Repository;

import com.ABCLaboratories.TestRegistrationSystem.model.Appointment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment,Integer> {
     @Query(value = "SELECT s FROM Appointment s WHERE PatientId=:val")
     public List<Appointment> fetchAppointment(@Param("val") String Id);
}
