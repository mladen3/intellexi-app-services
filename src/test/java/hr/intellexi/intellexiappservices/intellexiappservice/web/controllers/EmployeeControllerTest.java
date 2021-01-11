package hr.intellexi.intellexiappservices.intellexiappservice.web.controllers;

import static hr.intellexi.intellexiappservices.intellexiappservice.utils.EmployeeHelper.getOneTestEmployee;
import static hr.intellexi.intellexiappservices.intellexiappservice.utils.EmployeeHelper.getTestEmployeeDto;
import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import hr.intellexi.intellexiappservices.intellexiappservice.domain.Employee;
import hr.intellexi.intellexiappservices.intellexiappservice.mappers.EmployeeMapper;
import hr.intellexi.intellexiappservices.intellexiappservice.repositories.EmployeeRepository;
import hr.intellexi.intellexiappservices.intellexiappservice.utils.EmployeeHelper;
import hr.intellexi.intellexiappservices.intellexiappservice.web.model.EmployeeDto;
import hr.intellexi.intellexiappservices.intellexiappservice.web.services.EmployeeService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;


@WebMvcTest({
        EmployeeController.class,
        EmployeeService.class
})
class EmployeeControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    EmployeeService employeeService;

    @MockBean
    EmployeeRepository employeeRepository;

    @MockBean
    EmployeeMapper employeeMapper;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    void getEmployee() throws Exception {
        long id = 12345L;

        Mockito.when(employeeRepository.findById(id)).thenReturn(getOneTestEmployee(id));

        mockMvc.perform(get("/rest/v1/employee" + "/" + id).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }


    @Test
    void saveBeer() throws Exception {

        Mockito.when(employeeRepository.save(any())).thenReturn(any());

        mockMvc.perform(post("/rest/v1/employee")
                .content(objectMapper.writeValueAsString(getTestEmployeeDto()))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void updateEmployee() throws Exception {

        Mockito.when(employeeRepository.save(any())).thenReturn(any());

        EmployeeDto testEmployee = getTestEmployeeDto();

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

    @Test
    void findAllEmployees() throws Exception {
        Mockito.when(employeeRepository.findAll()).thenReturn(getIterableFromRepo());

        mockMvc.perform(get("/rest/v1/employee/findAll"))
                .andExpect(status().isOk());
    }

    private Iterable<Employee> getIterableFromRepo() {

        return EmployeeHelper.getTestEmployeeList();
    }
}
