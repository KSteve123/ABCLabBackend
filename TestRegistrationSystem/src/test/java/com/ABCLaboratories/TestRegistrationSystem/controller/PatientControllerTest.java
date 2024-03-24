package com.ABCLaboratories.TestRegistrationSystem.controller;

import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import com.ABCLaboratories.TestRegistrationSystem.model.Patient;
import com.ABCLaboratories.TestRegistrationSystem.service.PatientService;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {PatientController.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class PatientControllerTest {
    @Autowired
    private PatientController patientController;

    @MockBean
    private PatientService patientService;


    @Test
    void testAdd() throws Exception {
        // Arrange
        Patient patient = new Patient();
        patient.setAddress("42 Main St");
        patient.setEmail("jane.doe@example.org");
        patient.setId(1);
        patient.setName("Name");
        patient.setPassword("iloveyou");
        patient.setPhone("6625550144");
        when(patientService.SavePatient(Mockito.<Patient>any())).thenReturn(patient);

        Patient patient2 = new Patient();
        patient2.setAddress("42 Main St");
        patient2.setEmail("jane.doe@example.org");
        patient2.setName("Name");
        patient2.setPassword("iloveyou");
        patient2.setPhone("6625550144");
        String content = (new ObjectMapper()).writeValueAsString(patient2);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/patient/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);

        // Act and Assert
        MockMvcBuilders.standaloneSetup(patientController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("New patient added"));
    }

    /**
     * Method under test: {@link PatientController#deletePatient(int)}
     */
    @Test
    void testDeletePatient() throws Exception {
        // Arrange
        doNothing().when(patientService).deletePatient(anyInt());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/patient/delete/{id}", 1);

        // Act and Assert
        MockMvcBuilders.standaloneSetup(patientController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    /**
     * Method under test: {@link PatientController#deletePatient(int)}
     */
    @Test
    void testDeletePatient2() throws Exception {
        // Arrange
        doNothing().when(patientService).deletePatient(anyInt());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/patient/delete/{id}", 1);
        requestBuilder.contentType("https://example.org/example");

        // Act and Assert
        MockMvcBuilders.standaloneSetup(patientController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    /**
     * Method under test: {@link PatientController#getPatientById(int)}
     */
    @Test
    void testGetPatientById() throws Exception {
        // Arrange
        Patient patient = new Patient();
        patient.setAddress("42 Main St");
        patient.setEmail("jane.doe@example.org");
        patient.setId(1);
        patient.setName("Name");
        patient.setPassword("iloveyou");
        patient.setPhone("6625550144");
        when(patientService.getPatientById(1)).thenReturn(patient);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/patient/patient/1");

        // Act and Assert
        MockMvcBuilders.standaloneSetup(patientController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.name").value("Name"))
                .andExpect(jsonPath("$.address").value("42 Main St"))
                .andExpect(jsonPath("$.password").value("iloveyou"))
                .andExpect(jsonPath("$.email").value("jane.doe@example.org"))
                .andExpect(jsonPath("$.phone").value("6625550144"));

    }

    /**
     * Method under test: {@link PatientController#getAllPatients()}
     */
    @Test
    void testGetAllPatients() throws Exception {
        // Arrange
        when(patientService.getAllPatients()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/patient/getAll");

        // Act and Assert
        MockMvcBuilders.standaloneSetup(patientController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link PatientController#updateStudent(Patient, int)}
     */
    @Test
    void testUpdateStudent() throws Exception {
        // Arrange
        Patient patient = new Patient();
        patient.setAddress("42 Main St");
        patient.setEmail("jane.doe@example.org");
        patient.setId(1);
        patient.setName("Name");
        patient.setPassword("iloveyou");
        patient.setPhone("6625550144");
        when(patientService.updatePatient(Mockito.<Patient>any(), anyInt())).thenReturn(patient);

        Patient patient2 = new Patient();
        patient2.setAddress("42 Main St");
        patient2.setEmail("jane.doe@example.org");
        patient2.setId(1);
        patient2.setName("ame");
        patient2.setPassword("iloveyou");
        patient2.setPhone("6625550144");
        String content = (new ObjectMapper()).writeValueAsString(patient2);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/patient/update/{id}", 1)
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);

        // Act and Assert
        MockMvcBuilders.standaloneSetup(patientController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(jsonPath("$.id").value(patient2.getId()))
                .andExpect(jsonPath("$.name").value("Name"))
                .andExpect(jsonPath("$.address").value("42 Main St"))
                .andExpect(jsonPath("$.password").value("iloveyou"))
                .andExpect(jsonPath("$.email").value("jane.doe@example.org"))
                .andExpect(jsonPath("$.phone").value("6625550144"));
    }
}
