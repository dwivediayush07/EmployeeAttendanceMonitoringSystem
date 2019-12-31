package com.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.employee.service.IAdminStaffService;

@RestController

public class AdminStaffController {
	@Autowired
	IAdminStaffService adminStaffService;

	@RequestMapping(method = RequestMethod.GET, value = "/loginadminStaff/{adminStaffId}/{password}")
	public String login(@PathVariable int adminStaffId, @PathVariable String password) {
		return adminStaffService.login(adminStaffId, password);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/updateAttendance/{empId}/{status}")
	public String updateEmpAttendance(@PathVariable int empId, @PathVariable String status) {
		return adminStaffService.updateEmpAttendance(empId, status);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/calculateLOP/{empId}")
	public float calculateLOP(@PathVariable int empId) {
		return adminStaffService.calculateLOP(empId);
	}

}
