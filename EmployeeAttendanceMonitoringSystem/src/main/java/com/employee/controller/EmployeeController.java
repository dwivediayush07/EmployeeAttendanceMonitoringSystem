package com.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.employee.bean.Attendance;
import com.employee.bean.Employee;
import com.employee.service.IEmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	IEmployeeService empService;

	@RequestMapping(method = RequestMethod.GET, value = "/loginemployee/{empId}/{password}")
	public String login(@PathVariable int empId, @PathVariable String password) {
		return empService.login(empId, password);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/viewAttendance/{empId}")
	public Attendance viewAttendance(@PathVariable int empId) {
		return empService.viewEmpAttendance(empId);

	}

	@RequestMapping(method = RequestMethod.GET, value = "/viewLOP/{empId}")
	public float viewEmpLOP(@PathVariable int empId) {
		return empService.viewEmpLOP(empId);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/applyLeave/{empId}/{leaveApplied}")
	public Employee applyLeave(@PathVariable int empId, @PathVariable int leaveApplied) {
		return empService.applyLeave(empId, leaveApplied);
	}

}
