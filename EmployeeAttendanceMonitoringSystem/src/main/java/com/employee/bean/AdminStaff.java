package com.employee.bean;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AdminStaff {
	@Id
	private int adminStaffId;
	private String name;
	private String password;

	// Getter and Setter
	public int getAdminStaffId() {
		return adminStaffId;
	}

	public void setAdminStaffId(int adminStaffId) {
		this.adminStaffId = adminStaffId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	// toString
	@Override
	public String toString() {
		return "AdminStaff [adminStaffId=" + adminStaffId + ", name=" + name + ", password=" + password + "]";
	}

	// Constructor from SuperClass
	public AdminStaff() {
		super();
		// TODO Auto-generated constructor stub
	}

}