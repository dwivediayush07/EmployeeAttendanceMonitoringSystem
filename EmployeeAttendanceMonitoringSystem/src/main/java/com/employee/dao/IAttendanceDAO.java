package com.employee.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employee.bean.Attendance;

public interface IAttendanceDAO extends JpaRepository<Attendance, Integer> {

}
