package com.example.SpringJDBCCrud.repository;

import java.util.List;

import com.example.SpringJDBCCrud.model.Employee;

public interface EmployeeRepository {

	List<Employee> viewFunction();
	String insertFunction(Employee e);
	String UpdateFunction(Employee e);
	Employee viewById(Integer id);
	String deletebyId(Integer id);
}
