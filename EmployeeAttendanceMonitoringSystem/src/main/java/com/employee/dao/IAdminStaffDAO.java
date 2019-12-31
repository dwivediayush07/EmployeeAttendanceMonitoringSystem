package com.employee.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employee.bean.AdminStaff;

public interface IAdminStaffDAO extends JpaRepository<AdminStaff, Integer> {

}
