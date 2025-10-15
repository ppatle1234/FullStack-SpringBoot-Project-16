package com.fullstack.controller;

import com.fullstack.model.Employee;
import com.fullstack.service.IEmployeeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private IEmployeeService employeeService;

    @GetMapping("/getalldata")
    public ResponseEntity<List<Employee>> getAllData(){
        return new ResponseEntity<>(employeeService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<Employee> saveData(@RequestBody Employee employee){
        return new ResponseEntity<>(employeeService.save(employee), HttpStatus.CREATED);

    }

    @PutMapping("/update/{empId}")
    public ResponseEntity<Employee> updateData(@PathVariable long empId, @RequestBody Employee employee){
        return new ResponseEntity<>(employeeService.update(empId, employee), HttpStatus.CREATED);
    }

    @DeleteMapping("/deletebyid/{empId}")
    public ResponseEntity<String> deleteDataById(@PathVariable long empId){
        employeeService.deleteDataById(empId);
        return new ResponseEntity<>("Data Deleted Successfully", HttpStatus.OK);
    }
}
