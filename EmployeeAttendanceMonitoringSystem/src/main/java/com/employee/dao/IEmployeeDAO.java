package com.employee.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employee.bean.Employee;

@Repository
public interface IEmployeeDAO extends JpaRepository<Employee, Integer> {

}
