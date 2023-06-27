package com.crud.controller;

import java.util.List;

import com.crud.common.APIResponse;
import com.crud.model.Employee;

public interface EmployeeController {

	String saveDB(Employee emp);

	APIResponse getAllEmployee();

	String deleteEmployee(int id);

	APIResponse getEmployeeByID(int id);

	Employee update(Employee emp);

}
