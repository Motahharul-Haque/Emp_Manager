package com.salezshark.employeemanager.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salezshark.employeemanager.exception.UserNotFoundException;
import com.salezshark.employeemanager.model.Employee;
import com.salezshark.employeemanager.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	public Employee addEmployee(Employee employee)
	{
		employee.setEmployeeCode(UUID.randomUUID().toString());
		return employeeRepository.save(employee);
	}
	
	public List<Employee> findAllEmployee()
	{
		return employeeRepository.findAll();
	}
	
	public Employee updateEmployee(Employee employee)
	{
		return employeeRepository.save(employee);
	}
	
	public Employee findEmployeeById(Long id)
	{
		return employeeRepository.findEmployeeById(id).orElseThrow(() -> new UserNotFoundException("User by id "+id+" not found"));
	}
	public void deleteEmployee(Long id)
	{
		employeeRepository.deleteEmployeeById(id);
	}
	
	
}