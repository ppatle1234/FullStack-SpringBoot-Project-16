package com.fullstack.service;

import com.fullstack.exception.RecordNotFoundException;
import com.fullstack.model.Employee;
import com.fullstack.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class EmployeeServiceImpl implements IEmployeeService{

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Optional<Employee> findByEmpId(long empId) {
        return Optional.ofNullable(employeeRepository.findById(empId).orElseThrow(() -> new RecordNotFoundException("Employee ID Does Not Exist")));
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee update(long empId, Employee employee) {

        Employee employee1 = findByEmpId(empId).get();

        employee1.setEmpName(employee.getEmpName());
        employee1.setEmpSalary(employee.getEmpSalary());
        employee1.setEmpDOB(employee.getEmpDOB());
        employee1.setEmpContactNumber(employee.getEmpContactNumber());
        return employeeRepository.save(employee1);
    }

    @Override
    public void deleteDataById(long empId) {
         employeeRepository.deleteById(empId);
    }
}
