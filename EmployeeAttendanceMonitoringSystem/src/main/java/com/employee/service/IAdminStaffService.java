package com.employee.service;

public interface IAdminStaffService {
	public String login(int adminStaffId, String password);

	public String updateEmpAttendance(int empId, String status);

	public float calculateLOP(int empId);

}
