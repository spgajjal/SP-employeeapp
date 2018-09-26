package com.capgemini.employeeapp.repository.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.capgemini.employeeapp.entities.Employee;
import com.capgemini.employeeapp.repository.EmployeeRepository;
@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository{
@Autowired
private JdbcTemplate jdbcTemplate;

	public Employee addEmployee(Employee employee) {
		int count=jdbcTemplate.update("insert into Employees values(?,?,?,?)",new Object[] {employee.getEmployeeId(),employee.getEmployeeName(),employee.getEmployeeDepartment(),employee.getEmployeeSalary()}); 
	if(count!=0)
		return employee;
	else 
		return null;
	}

	public Employee updateEmployee(Employee employee) {
		int count=jdbcTemplate.update("update Employees set Employee_name=?,Employee_department=?,Employee_salary=? where employee_Id=?",new Object[] {employee.getEmployeeName(),employee.getEmployeeDepartment(),employee.getEmployeeSalary(),employee.getEmployeeId()});
		if(count!=0)
			return employee;
		else 
			return null;
	}

	public boolean deleteEmployee(int employeeId) {
		int count=jdbcTemplate.update("delete from Employees where Employee_Id=?",new Object[] {employeeId});
		return count!=0;
	}

	public Employee findEmployeebyId(int employeeId) {
		return jdbcTemplate.queryForObject("select * from Employees where Employee_Id=?",new Object[] {employeeId},new EmployeeRowMapper());
		 
	}

	public List<Employee> findAllEmployees() {
		return jdbcTemplate.query("Select * from Employees",new Object[] {}, new EmployeeRowMapper());
	}

	private class EmployeeRowMapper implements RowMapper<Employee>
	{
@Override
		public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
			Employee employee=new Employee();
			employee.setEmployeeId(rs.getInt(1));
			employee.setEmployeeName(rs.getString(2));
			employee.setEmployeeDepartment(rs.getString(3));
			employee.setEmployeeSalary(rs.getDouble(4));
			return employee;
			
		}
		}
		
}
