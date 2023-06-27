package com.crud.service;

import java.util.List;

import com.crud.common.APIResponse;
import com.crud.model.Employee;

public interface ServiceEmployee {

	void saveDAO(Employee emp);

	void deleteDAO(int id);

	List<Employee> getAllEmployee();

	Employee getEmployeeByIdService(int id);

	Employee updateEmployee(Employee emp);

}
