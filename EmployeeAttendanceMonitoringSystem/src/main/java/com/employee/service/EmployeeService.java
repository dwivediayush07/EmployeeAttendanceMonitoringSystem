package com.employee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.bean.Attendance;
import com.employee.bean.Employee;
import com.employee.dao.IAttendanceDAO;
import com.employee.dao.IEmployeeDAO;

@Service
public class EmployeeService implements IEmployeeService {
	@Autowired
	IEmployeeDAO EmployeeDAO;
	@Autowired
	IAttendanceDAO AttendanceDAO;

	@Override
	public String login(int empId, String password) {
		if (EmployeeDAO.findById(empId) != null) {
			Employee emp = EmployeeDAO.findById(empId).get();
			if (emp.getEmpPassword().equals(password)) {
				return "Login Successfull.";
			}
		}
		return "Login Failed.";
	}

	@Override
	public Attendance viewEmpAttendance(int empId) {
		if (EmployeeDAO.findById(empId) != null) {
			Attendance att = AttendanceDAO.findById(empId).get();
			return att;
		}
		return null;
	}

	@Override
	public float viewEmpLOP(int empId) {
		if (EmployeeDAO.findById(empId) != null) {
			Employee emp = EmployeeDAO.findById(empId).get();
			return emp.getEmpLOP();
		}
		return 0;
	}

	@Override
	public Employee applyLeave(int empId, int leaveApplied) {
		if (EmployeeDAO.findById(empId) != null) {
			Employee emp = EmployeeDAO.findById(empId).get();
			emp.setLeaveApplied(leaveApplied + emp.getLeaveApplied());
			EmployeeDAO.save(emp);
			return emp;
		}
		return null;
	}

}
