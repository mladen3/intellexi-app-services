package hr.intellexi.intellexiappservices.intellexiappservice.web.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import hr.intellexi.intellexiappservices.intellexiappservice.web.domain.Employee;
import hr.intellexi.intellexiappservices.intellexiappservice.web.mappers.EmployeeMapper;
import hr.intellexi.intellexiappservices.intellexiappservice.web.model.EmployeeDto;
import hr.intellexi.intellexiappservices.intellexiappservice.web.repositories.EmployeeRepository;
import hr.intellexi.intellexiappservices.intellexiappservice.web.services.EmployeeService;
import hr.intellexi.intellexiappservices.intellexiappservice.web.services.impl.UserServiceImpl;
import hr.intellexi.intellexiappservices.intellexiappservice.web.utils.EmployeeHelper;
import hr.intellexi.intellexiappservices.intellexiappservice.web.utils.JwtHelper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;




@WebMvcTest(controllers={
        EmployeeController.class,
        EmployeeService.class
})
@AutoConfigureMockMvc(addFilters = false)
class EmployeeControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    EmployeeService employeeService;

    @MockBean
    EmployeeRepository employeeRepository;

    @MockBean
    UserServiceImpl userServiceImpl;

    @MockBean
    EmployeeMapper employeeMapper;

    @MockBean
    JwtHelper jwtHelper;

    @MockBean
    PasswordEncoder passwordEncoder;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    void getEmployee() throws Exception {
        long id = 12345L;

        Mockito.when(employeeRepository.findById(id)).thenReturn(EmployeeHelper.getOneTestEmployee(id));

        mockMvc.perform(get("/rest/v1/employee" + "/" + id).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }


    @Test
    void saveBeer() throws Exception {

        Mockito.when(employeeRepository.save(any())).thenReturn(any());

        mockMvc.perform(post("/rest/v1/employee")
                .content(objectMapper.writeValueAsString(EmployeeHelper.getTestEmployeeDto()))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void updateEmployee() throws Exception {

        Mockito.when(employeeRepository.save(any())).thenReturn(any());

        EmployeeDto testEmployee = EmployeeHelper.getTestEmployeeDto();

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
