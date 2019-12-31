package com.employee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.bean.AdminStaff;
import com.employee.bean.Attendance;
import com.employee.bean.Employee;
import com.employee.dao.IAdminStaffDAO;
import com.employee.dao.IAttendanceDAO;
import com.employee.dao.IEmployeeDAO;

@Service
public class AdminStaffService implements IAdminStaffService {
	@Autowired
	IAdminStaffDAO AdminStaffDAO;
	@Autowired
	IEmployeeDAO EmployeeDAO;
	@Autowired
	IAttendanceDAO AttendanceDAO;

	@Override
	public String login(int adminStaffId, String password) {
		if (AdminStaffDAO.findById(adminStaffId) != null) {
			AdminStaff as = AdminStaffDAO.findById(adminStaffId).get();
			if (as.getPassword().equals(password)) {
				return "Login successful.";
			}
		}
		return "Login Failed.";
	}

	@Override
	public String updateEmpAttendance(int empId, String status) {
		if (EmployeeDAO.findById(empId) != null) {
			Employee e = EmployeeDAO.findById(empId).get();
			if (((e.getTotalAbsent() + e.getTotalPresent())) >= 30) {
				if (status.equals("Present")) {
					Employee emp = EmployeeDAO.findById(empId).get();
					Attendance att = AttendanceDAO.findById(empId).get();
					emp.setTotalPresent(1);
					att.setTotalPresent(1);
					emp.setTotalAbsent(0);
					att.setTotalAbsent(0);
					att.setWorkingDays(att.getTotalAbsent() + att.getTotalPresent());
					emp.setEmpSalary(emp.getEmpSalary() + emp.getEmpLOP());
					emp.setEmpLOP(0);
					emp.setLeaveApplied(0);
					EmployeeDAO.save(emp);
					AttendanceDAO.save(att);
				} else if (status.equals("Absent")) {
					Employee emp = EmployeeDAO.findById(empId).get();
					Attendance att = AttendanceDAO.findById(empId).get();
					emp.setEmpSalary(emp.getEmpSalary() + emp.getEmpLOP());
					emp.setEmpLOP(0);
					emp.setLeaveApplied(0);
					emp.setTotalPresent(0);
					att.setTotalPresent(0);
					emp.setTotalAbsent(1);
					att.setTotalAbsent(1);
					EmployeeDAO.save(emp);
					AttendanceDAO.save(att);
				}
			} else if ((e.getTotalAbsent() + e.getTotalPresent()) <= e.getWorkingDays()) {
				if (status.equals("Present")) {
					Employee emp = EmployeeDAO.findById(empId).get();
					Attendance att = AttendanceDAO.findById(empId).get();
					emp.setTotalPresent((emp.getTotalPresent() + 1));
					att.setTotalPresent((emp.getTotalPresent()));
					att.setWorkingDays(att.getWorkingDays() + 1);
					EmployeeDAO.save(emp);
					AttendanceDAO.save(att);
				} else if (status.equals("Absent")) {
					Employee emp = EmployeeDAO.findById(empId).get();
					Attendance att = AttendanceDAO.findById(empId).get();
					emp.setTotalAbsent(emp.getTotalAbsent() + 1);
					att.setTotalAbsent(emp.getTotalAbsent());
					att.setWorkingDays(att.getWorkingDays() + 1);
					EmployeeDAO.save(emp);
					AttendanceDAO.save(att);
				}
			}
		}
		return null;
	}

	@Override
	public float calculateLOP(int empId) {
		if (EmployeeDAO.findById(empId) != null) {
			Employee emp = EmployeeDAO.findById(empId).get();
			if (emp.getWorkingDays() == (emp.getTotalAbsent() + emp.getTotalPresent())) {
				if (emp.getTotalAbsent() > emp.getEmpLeave()) {
					int l = emp.getTotalAbsent() - emp.getEmpLeave();
					float lop = (emp.getEmpSalary() / 30) * l;
					emp.setEmpLOP(lop);
					EmployeeDAO.save(emp);

					emp.setEmpSalary(emp.getEmpSalary() - lop);
					emp.setLeaveApplied(emp.getTotalAbsent());
					EmployeeDAO.save(emp);
				}
				return 0;
			}
			if (emp.getTotalAbsent() + emp.getTotalPresent() > 30) {
				emp.setEmpLOP(0);
				emp.setEmpSalary(emp.getEmpSalary() + emp.getEmpLOP());
				emp.setLeaveApplied(0);
				emp.setTotalAbsent(0);
				emp.setTotalPresent(0);
				EmployeeDAO.save(emp);
			}

		}
		return 0;

	}

}
