package com.ABCLaboratories.TestRegistrationSystem.controller;

import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import com.ABCLaboratories.TestRegistrationSystem.model.Appointment;
import com.ABCLaboratories.TestRegistrationSystem.service.AppointmentService;
import com.ABCLaboratories.TestRegistrationSystem.service.EmailSenderService;
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

@ContextConfiguration(classes = {AppointmentController.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class AppointmentControllerTest {
  @Autowired
  private AppointmentController appointmentController;

  @MockBean
  private AppointmentService appointmentService;

  @MockBean
  private EmailSenderService emailSenderService;
  /**
   * Method under test: {@link AppointmentController#getAppointmentById(int)}
   */
  @Test
  void testGetAppointmentById() throws Exception {
    // Arrange
    Appointment appointment = new Appointment();
    appointment.setId(5);
    appointment.setDate("0000-00-00");
    appointment.setTestName("Urine");
    appointment.setPatientId("1");
    appointment.setPayment("Paid");
    appointment.setTechnicianID("1");
    appointment.setDoctorName("Doctor 1");
    when(appointmentService.getAppointmentById(5)).thenReturn(appointment);
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/appointment/appointment/5");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(appointmentController)
            .build()
            .perform(requestBuilder)
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
            .andExpect(jsonPath("$.id").value(5))
            .andExpect(jsonPath("$.date").value("0000-00-00"))
            .andExpect(jsonPath("$.testName").value("Urine"))
            .andExpect(jsonPath("$.patientId").value("1"))
            .andExpect(jsonPath("$.payment").value("Paid"))
            .andExpect(jsonPath("$.technicianID").value("1"))
            .andExpect(jsonPath("$.doctorName").value("Doctor 1"));
  }

  /**
   * Method under test: {@link AppointmentController#getAllAppointments()}
   */
  @Test
  void testGetAllAppointments() throws Exception {
    // Arrange
    when(appointmentService.getAllAppointments()).thenReturn(new ArrayList<>());
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/appointment/getAll");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(appointmentController)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
        .andExpect(MockMvcResultMatchers.content().string("[]"));
  }

  /**
   * Method under test:
   * {@link AppointmentController#updateAppointment(Appointment, int)}
   */
  @Test
  void testUpdateAppointment() throws Exception {
    // Arrange
    Appointment appointment = new Appointment();
    appointment.setDate("2020-03-01");
    appointment.setDoctorName("Doctor Name");
    appointment.setId(1);
    appointment.setPatientId("42");
    appointment.setPayment("Paid");
    appointment.setTechnicianID("2");
    appointment.setTestName("Urine");
    when(appointmentService.updateAppointment(Mockito.<Appointment>any(), anyInt())).thenReturn(appointment);

    Appointment appointment2 = new Appointment();
    appointment2.setDate("2020-03-01");
    appointment2.setDoctorName("Doctor Name");
    appointment2.setId(1);
    appointment2.setPatientId("42");
    appointment2.setPayment("not paid");
    appointment2.setTechnicianID("2");
    appointment2.setTestName("Urine");
    String content = (new ObjectMapper()).writeValueAsString(appointment2);
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/appointment/update/1")
        .contentType(MediaType.APPLICATION_JSON)
        .content(content);

    // Act and Assert
    MockMvcBuilders.standaloneSetup(appointmentController)
            .build()
            .perform(requestBuilder)
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
            .andExpect(jsonPath("$.id").value(1))
            .andExpect(jsonPath("$.date").value("2020-03-01"))
            .andExpect(jsonPath("$.testName").value("Urine"))
            .andExpect(jsonPath("$.patientId").value("42"))
            .andExpect(jsonPath("$.payment").value("Paid"))
            .andExpect(jsonPath("$.technicianID").value("2"))
            .andExpect(jsonPath("$.doctorName").value("Doctor Name"));
  }

  /**
   * Method under test:
   * {@link AppointmentController#updateAppointment(Appointment, int)}
   */
  @Test
  void testUpdateAppointment2() throws Exception {
    // Arrange
    Appointment appointment = new Appointment();
    appointment.setDate("2020-03-01");
    appointment.setDoctorName("Doctor Name");
    appointment.setId(1);
    appointment.setPatientId("42");
    appointment.setPayment("Paid");
    appointment.setTechnicianID("2");
    appointment.setTestName("Urine");
    when(appointmentService.updateAppointment(Mockito.<Appointment>any(), anyInt())).thenReturn(appointment);
    doNothing().when(emailSenderService).sendEmail(Mockito.<String>any(), Mockito.<String>any(), Mockito.<String>any());

    Appointment appointment2 = new Appointment();
    appointment2.setDate("2020-03-01");
    appointment2.setDoctorName("Doctor Name");
    appointment2.setId(1);
    appointment2.setPatientId("42");
    appointment2.setPayment("Paid");
    appointment2.setTechnicianID("Technician ID");
    appointment2.setTestName("Test Name");
    String content = (new ObjectMapper()).writeValueAsString(appointment2);
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/appointment/update/{id}", 1)
        .contentType(MediaType.APPLICATION_JSON)
        .content(content);

    // Act and Assert
    MockMvcBuilders.standaloneSetup(appointmentController)
            .build()
            .perform(requestBuilder)
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
            .andExpect(jsonPath("$.id").value(1))
            .andExpect(jsonPath("$.date").value("2020-03-01"))
            .andExpect(jsonPath("$.testName").value("Urine"))
            .andExpect(jsonPath("$.patientId").value("42"))
            .andExpect(jsonPath("$.payment").value("Paid"))
            .andExpect(jsonPath("$.technicianID").value("2"))
            .andExpect(jsonPath("$.doctorName").value("Doctor Name"));
  }

  /**
   * Method under test: {@link AppointmentController#add(Appointment)}
   */
  @Test
  void testAdd() throws Exception {
    // Arrange
    Appointment appointment = new Appointment();
    appointment.setDate("2020-03-01");
    appointment.setDoctorName("Doctor Name");
    appointment.setPatientId("42");
    appointment.setPayment("Payment");
    appointment.setTechnicianID("Technician ID");
    appointment.setTestName("Test Name");
    when(appointmentService.SaveAppointment(Mockito.<Appointment>any())).thenReturn(appointment);

    Appointment appointment2 = new Appointment();
    appointment2.setDate("2020-03-01");
    appointment2.setDoctorName("Doctor Name");
    appointment2.setId(1);
    appointment2.setPatientId("42");
    appointment2.setPayment("Payment");
    appointment2.setTechnicianID("Technician ID");
    appointment2.setTestName("Test Name");
    String content = (new ObjectMapper()).writeValueAsString(appointment2);
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/appointment/add")
        .contentType(MediaType.APPLICATION_JSON)
        .content(content);

    // Act and Assert
    MockMvcBuilders.standaloneSetup(appointmentController)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
        .andExpect(MockMvcResultMatchers.content().string("New patient added"));
  }

  /**
   * Method under test: {@link AppointmentController#deleteAppointment(int)}
   */
  @Test
  void testDeleteAppointment() throws Exception {
    // Arrange
    doNothing().when(appointmentService).deleteAppointment(anyInt());
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/appointment/delete/{id}", 1);

    // Act and Assert
    MockMvcBuilders.standaloneSetup(appointmentController)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk());
  }

  /**
   * Method under test: {@link AppointmentController#deleteAppointment(int)}
   */
  @Test
  void testDeleteAppointment2() throws Exception {
    // Arrange
    doNothing().when(appointmentService).deleteAppointment(1);
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/appointment/delete/{id}", 1);

    // Act and Assert
    MockMvcBuilders.standaloneSetup(appointmentController)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk());
  }

  /**
   * Method under test: {@link AppointmentController#getpatientId(String)}
   */
  @Test
  void testGetpatientId() throws Exception {
    // Arrange
    when(appointmentService.fetchAppointment(Mockito.<String>any())).thenReturn(new ArrayList<>());
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
        .get("/appointment/appointment/all/{patientId}", "42");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(appointmentController)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
        .andExpect(MockMvcResultMatchers.content().string("[]"));
  }
}
