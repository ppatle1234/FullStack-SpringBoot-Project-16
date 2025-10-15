package com.fullstack.service;

import com.fullstack.model.Employee;

import java.util.List;
import java.util.Optional;

public interface IEmployeeService {

     Employee save(Employee employee);

     Optional<Employee> findByEmpId(long empId);

     List<Employee> findAll();

     Employee update(long empId, Employee employee);

     void deleteDataById(long empId);


}
