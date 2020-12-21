package com.example.SpringJDBCCrud.implementation;

import java.sql.Types;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.SpringJDBCCrud.model.Employee;
import com.example.SpringJDBCCrud.repository.EmployeeRepository;

@Repository
public class EmployeeImplementation implements EmployeeRepository{

	@Autowired
	JdbcTemplate jdbcTemplate;
	public List<Employee> viewFunction() {
		// TODO Auto-generated method stub
		String sql="select * from employee";
		List<Employee> list=jdbcTemplate.query(sql,new BeanPropertyRowMapper(Employee.class));
		return list;
	}
	public String insertFunction(Employee e) {
		// TODO Auto-generated method stub
		String sql="insert into employee values(?,?,?)";
		jdbcTemplate.update(sql,new Object[] {e.getId(),e.getName(),e.getCity()});
		return "employee added with id="+e.getId();
	}
	public String UpdateFunction(Employee e) {
		// TODO Auto-generated method stub
		String sql="update employee set name=? where id=?";
		jdbcTemplate.update(sql,new Object[] {e.getName(),e.getId()});
		return "employee updated";
	}
	public Employee viewById(Integer id) {
		// TODO Auto-generated method stub
		String sql="select * from employee where id=?";
		Employee e=(Employee)jdbcTemplate.queryForObject(sql,new Object[] {id},new int[] {Types.INTEGER},new BeanPropertyRowMapper(Employee.class));
		return e;
	}
	public String deletebyId(Integer id) {
		// TODO Auto-generated method stub
		String sql="delete from employee where id=?";
		jdbcTemplate.update(sql, id);
		return "Employee Deleted successfully";
	}

}
