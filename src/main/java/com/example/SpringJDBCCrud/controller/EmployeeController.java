package com.example.SpringJDBCCrud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.SpringJDBCCrud.implementation.EmployeeImplementation;
import com.example.SpringJDBCCrud.model.Employee;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeImplementation e;
	
	@GetMapping("/view")
	public List<Employee> view(){
		return e.viewFunction();
	}
	
	@GetMapping("/viewById/{id}")
	public Employee view(@PathVariable Integer id){
		return e.viewById(id);
	}
	
	@DeleteMapping("/deleteById/{id}")
	public String delete(@PathVariable Integer id){
		return e.deletebyId(id);
	}
	
	@PostMapping("/insert")
	public String insert(@RequestBody Employee employee) {
		return e.insertFunction(employee);
	}
	
	@PutMapping("/update")
	public String update(@RequestBody Employee employee) {
		return e.UpdateFunction(employee);
	}
}
