package com.java.employeemanager.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.employeemanager.exception.UserNotFoundException;
import com.java.employeemanager.model.Employee;
import com.java.employeemanager.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepo;
	
	public Employee addEmployee(Employee employee) {
		employee.setEmployeeCode(UUID.randomUUID().toString());
		return employeeRepo.save(employee);
	}
	
	public List<Employee> findAllEmployees(){
		return employeeRepo.findAll();
	}
	
	public Employee updateEmployee(Employee employee) {
		return employeeRepo.save(employee);
	}
	
	public Employee findEmployeeById(Long empId) {
		return employeeRepo.findById(empId)
				.orElseThrow(() -> new UserNotFoundException("User" + empId + "not found"));
	}
	
	public void deleteEmployee(Long empId) {
		employeeRepo.deleteById(empId);
	}
}
