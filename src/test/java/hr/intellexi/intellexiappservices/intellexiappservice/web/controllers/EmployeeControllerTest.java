package hr.intellexi.intellexiappservices.intellexiappservice.web.controllers;

import static hr.intellexi.intellexiappservices.intellexiappservice.utils.EmployeeHelper.getTestEmployee;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import hr.intellexi.intellexiappservices.intellexiappservice.web.model.EmployeeDto;
import hr.intellexi.intellexiappservices.intellexiappservice.web.services.EmployeeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;


@WebMvcTest({EmployeeController.class, EmployeeService.class})
class EmployeeControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    EmployeeService employeeService;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    void getEmployee() throws Exception {
        mockMvc.perform(get("/rest/v1/employee" + "/12345").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void saveBeer() throws Exception {

        EmployeeDto testEmployee = getTestEmployee();


        mockMvc.perform(post("/rest/v1/employee")
                .content(objectMapper.writeValueAsString(testEmployee))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void updateEmployee() throws Exception {
        EmployeeDto testEmployee = getTestEmployee();

        mockMvc.perform(put("/rest/v1/employee")
                .content(objectMapper.writeValueAsString(testEmployee))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isAccepted());
    }

    @Test
    void deleteEmployee() throws Exception {
        mockMvc.perform(delete("/rest/v1/employee" + "/12345"))
                .andExpect(status().isNoContent());
    }

}