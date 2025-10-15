package com.fullstack.service.test;

import com.fullstack.model.Employee;
import com.fullstack.repository.EmployeeRepository;
import com.fullstack.service.EmployeeServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import java.util.Date;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootTest
public class EmployeeServiceTest {

    @InjectMocks
    private EmployeeServiceImpl employeeService;

    @MockitoBean
    private EmployeeRepository employeeRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void saveTest() {
        Employee employee = new Employee(121, "Prashant", 8906.90, 899994883, new Date());

        employeeService.save(employee);

        Mockito.verify(employeeRepository, Mockito.times(1)).save(employee);
    }

    @Test
    public void findAllTest() {
        Mockito.when(employeeRepository.findAll()).thenReturn(Stream.of(new Employee(101, "Rahul", 18906.90, 909994883, new Date()),
                new Employee(102, "Sunil", 9906.90, 941133883, new Date()),
                new Employee(103, "Rahul", 18906.90, 909994883, new Date())).toList());

        Assertions.assertEquals(3, employeeService.findAll().stream().collect(Collectors.counting()));
    }

    @Test
    public void findByIdTest(){
        Mockito.when(employeeRepository.findById(101L)).thenReturn(Optional.ofNullable(new Employee(103, "Rahul", 18906.90, 909994883, new Date())));

        employeeRepository.findById(101L);

        Mockito.verify(employeeRepository, Mockito.times(1)).findById(101L);
    }

    @Test
    public void saveTest1(){

        Employee employee = new Employee(103, "Rahul", 18906.90, 909994883, new Date());

        employeeService.save(employee);

        Mockito.verify(employeeRepository, Mockito.times(1)).save(employee);
    }

    @Test
    @Disabled
    public void updateTest(){

        Employee employee = new Employee(103, "Rahul Temre China", 20000.90, 909994883, new Date());

        employeeService.update(employee.getEmpId() ,employee);

        Mockito.verify(employeeRepository, Mockito.times(1)).save(employee);
    }

    @Test
    public void deleteByIdTest(){

        Employee employee = new Employee(102, "Sunil", 9906.90, 941133883, new Date());

        employeeService.deleteDataById(employee.getEmpId());

        Mockito.verify(employeeRepository, Mockito.times(1)).deleteById(employee.getEmpId());
    }
}
