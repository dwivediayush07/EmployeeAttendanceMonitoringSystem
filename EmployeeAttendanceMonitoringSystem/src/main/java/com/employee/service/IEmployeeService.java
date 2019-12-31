package com.employee.service;

import com.employee.bean.Attendance;
import com.employee.bean.Employee;

public interface IEmployeeService {
	public String login(int empId, String password);

	public Attendance viewEmpAttendance(int empId);

	public float viewEmpLOP(int empId);

	public Employee applyLeave(int empId, int leaveApplied);

}
