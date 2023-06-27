package com.crud.dao;

import org.springframework.data.repository.CrudRepository;

import com.crud.model.Employee;

public interface EmployeeDAO extends CrudRepository<Employee, Integer> {
	

}
