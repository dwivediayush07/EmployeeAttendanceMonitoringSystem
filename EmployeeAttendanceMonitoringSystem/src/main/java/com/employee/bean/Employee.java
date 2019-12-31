package com.employee.bean;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Employee {
	@Id
	private int empId;
	private String empName;
	private String empPassword;
	private int workingDays;
	private int totalPresent;
	private int totalAbsent;
	private float empSalary;
	private float empLOP;
	private int leaveApplied;
	private int empLeave;

	// Getter and Setter
	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpPassword() {
		return empPassword;
	}

	public void setEmpPassword(String empPassword) {
		this.empPassword = empPassword;
	}

	public int getWorkingDays() {
		return workingDays;
	}

	public void setWorkingDays(int workingDays) {
		this.workingDays = workingDays;
	}

	public int getTotalPresent() {
		return totalPresent;
	}

	public void setTotalPresent(int totalPresent) {
		this.totalPresent = totalPresent;
	}

	public int getTotalAbsent() {
		return totalAbsent;
	}

	public void setTotalAbsent(int totalAbsent) {
		this.totalAbsent = totalAbsent;
	}

	public float getEmpSalary() {
		return empSalary;
	}

	public void setEmpSalary(float empSalary) {
		this.empSalary = empSalary;
	}

	public float getEmpLOP() {
		return empLOP;
	}

	public void setEmpLOP(float empLOP) {
		this.empLOP = empLOP;
	}

	public int getLeaveApplied() {
		return leaveApplied;
	}

	public void setLeaveApplied(int leaveApplied) {
		this.leaveApplied = leaveApplied;
	}

	public int getEmpLeave() {
		return empLeave;
	}

	public void setEmpLeave(int empLeave) {
		this.empLeave = empLeave;
	}

	// hashCode and equals
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + empId;
		result = prime * result + Float.floatToIntBits(empLOP);
		result = prime * result + empLeave;
		result = prime * result + ((empName == null) ? 0 : empName.hashCode());
		result = prime * result + ((empPassword == null) ? 0 : empPassword.hashCode());
		result = prime * result + Float.floatToIntBits(empSalary);
		result = prime * result + leaveApplied;
		result = prime * result + totalAbsent;
		result = prime * result + totalPresent;
		result = prime * result + workingDays;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (empId != other.empId)
			return false;
		if (Float.floatToIntBits(empLOP) != Float.floatToIntBits(other.empLOP))
			return false;
		if (empLeave != other.empLeave)
			return false;
		if (empName == null) {
			if (other.empName != null)
				return false;
		} else if (!empName.equals(other.empName))
			return false;
		if (empPassword == null) {
			if (other.empPassword != null)
				return false;
		} else if (!empPassword.equals(other.empPassword))
			return false;
		if (Float.floatToIntBits(empSalary) != Float.floatToIntBits(other.empSalary))
			return false;
		if (leaveApplied != other.leaveApplied)
			return false;
		if (totalAbsent != other.totalAbsent)
			return false;
		if (totalPresent != other.totalPresent)
			return false;
		if (workingDays != other.workingDays)
			return false;
		return true;
	}

	// toString
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empPassword=" + empPassword + ", workingDays="
				+ workingDays + ", totalPresent=" + totalPresent + ", totalAbsent=" + totalAbsent + ", empSalary="
				+ empSalary + ", empLOP=" + empLOP + ", leaveApplied=" + leaveApplied + ", empLeave=" + empLeave + "]";
	}

	// Constructors using Fields
	public Employee(int empId, String empName, String empPassword, int workingDays, int totalPresent, int totalAbsent,
			float empSalary, float empLOP, int leaveApplied, int empLeave) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empPassword = empPassword;
		this.workingDays = workingDays;
		this.totalPresent = totalPresent;
		this.totalAbsent = totalAbsent;
		this.empSalary = empSalary;
		this.empLOP = empLOP;
		this.leaveApplied = leaveApplied;
		this.empLeave = empLeave;
	}

	// Constructors from SuperClass
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

}