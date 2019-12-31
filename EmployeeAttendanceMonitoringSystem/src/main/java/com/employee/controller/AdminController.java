package com.employee.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.employee.bean.Employee;
import com.employee.service.IAdminService;

@RestController
public class AdminController {
	@Autowired
	IAdminService adminService;

	@RequestMapping(method = RequestMethod.GET, value = "/loginadmin/{adminId}/{password}")
	public String login(@PathVariable int adminId, @PathVariable String password) {
		return adminService.login(adminId, password);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/add")
	public Employee add(@RequestBody Employee e) {
		return adminService.addEmpDetails(e);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/view/{empId}")
	public Optional<Employee> viewEmpDetails(@PathVariable int empId) {
		return adminService.viewEmpDetails(empId);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/delete/{empId}")
	public String deleteEmpDetails(@PathVariable int empId) {
		return adminService.deleteEmpDetails(empId);
	}

}
