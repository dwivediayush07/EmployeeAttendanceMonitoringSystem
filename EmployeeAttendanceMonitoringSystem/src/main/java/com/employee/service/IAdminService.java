package com.employee.service;

import java.util.Optional;

import com.employee.bean.Employee;

public interface IAdminService {
	public String login(int adminId, String password);

	public Employee addEmpDetails(Employee e);

	public String deleteEmpDetails(int empId);

	public Optional<Employee> viewEmpDetails(int empId);

}
