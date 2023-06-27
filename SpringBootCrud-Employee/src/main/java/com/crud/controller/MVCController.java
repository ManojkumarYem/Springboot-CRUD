package com.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.crud.common.APIResponse;
import com.crud.common.NoSuchElementException;
import com.crud.model.Employee;
import com.crud.service.EmployeeService;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.validation.Valid;

@RestController
@CrossOrigin
@JsonIgnoreProperties
public class MVCController implements EmployeeController {

	public MVCController() {
		System.out.println("Controller Object Created");
	}

	@Autowired
	EmployeeService service;

	@PostMapping("/saveEmployee")
	public String saveDB( Employee emp) {
		System.out.println("hiiiiii");
		service.saveDAO(emp);
		return "Success";
	}

//	@Cacheable(value = "Employees")
	@GetMapping("/viewAllEmployee")
	public APIResponse getAllEmployee() {
		APIResponse response = new APIResponse();
		response.setData(service.getAllEmployee());
		return response;
	}

	@DeleteMapping("/deleteEmployee/{empid}")
	public String deleteEmployee(@PathVariable("empid") int empId) {

		service.deleteDAO(empId);
		return "Deleted";
	}

	@GetMapping("/getEmployeeById/{empid}")
	public APIResponse getEmployeeByID(@PathVariable("empid") int empId) {
		APIResponse res = new APIResponse();

		if (empId > 20) {
			throw new NoSuchElementException("hiiiiiiiiii");
		} else {
			res.setData(service.getEmployeeByIdService(empId));
			return res;
		}

	}

	@PatchMapping("/updateEmployee")
	public Employee update(@Valid Employee emp) {
		service.updateEmployee(emp);
		return emp;

	}

}
