package com.employee.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.bean.Admin;
import com.employee.bean.Attendance;
import com.employee.bean.Employee;
import com.employee.dao.IAdminDAO;
import com.employee.dao.IAttendanceDAO;
import com.employee.dao.IEmployeeDAO;

@Service
public class AdminService implements IAdminService {

	@Autowired
	IAdminDAO AdminDAO;
	@Autowired
	IEmployeeDAO EmployeeDAO;
	@Autowired
	IAttendanceDAO AttandanceDAO;

	Attendance att = new Attendance();

	public AdminService(IAdminDAO AdminDAO) {
		super();
		this.AdminDAO = AdminDAO;
	}

	Admin admin;

	@Override
	public String login(int adminId, String password) {
		if (AdminDAO.findById(adminId) != null) {
			Admin ad = AdminDAO.findById(adminId).get();
			if (ad.getPassword().equals(password)) {
				return "Login successful.";
			}
		}
		return "Login Failed.";
	}

	@Override
	public Optional<Employee> viewEmpDetails(int empId) {
		if (EmployeeDAO.findById(empId) != null) {
			return EmployeeDAO.findById(empId);
		}
		return null;
	}

	@Override
	public Employee addEmpDetails(Employee e) {
		if (e.getTotalAbsent() + e.getTotalPresent() > 30) {
			return null;
		} else {
			EmployeeDAO.save(e);
			att.setEmpId(e.getEmpId());
			att.setTotalAbsent(e.getTotalAbsent());
			att.setTotalPresent(e.getTotalPresent());
			att.setWorkingDays(e.getTotalPresent() + e.getTotalAbsent());
			AttandanceDAO.save(att);
			return EmployeeDAO.save(e);
		}
	}

	@Override
	public String deleteEmpDetails(int empId) {
		if (EmployeeDAO.findById(empId) != null) {
			EmployeeDAO.deleteById(empId);
			AttandanceDAO.deleteById(empId);
		}
		return "Deleted";
	}
}