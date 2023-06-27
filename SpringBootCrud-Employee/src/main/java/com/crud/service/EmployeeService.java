package com.crud.service;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;
import org.springframework.util.ReflectionUtils.FieldFilter;

import com.crud.dao.EmployeeDAO;
import com.crud.mail.Mail;
import com.crud.model.Employee;

@Service
public class EmployeeService implements ServiceEmployee {

	private EmployeeDAO dao;

	public EmployeeService(EmployeeDAO dao) {
		this.dao = dao;
		System.out.println("Service Object Created");

	}

	@Autowired
	Mail mail;

	public void saveDAO(Employee emp) {
		// String mailid = emp.getMailID();
		// String name = emp.getName();
		String msg = "Hi mr. " + emp.getName() + "\nYou were Joined in our JMI company \nLet Continue your Career ";

//		Random random = new Random();
//		int otp = 100000 + random.nextInt(900000);
//		
//		String msg =""+otp;

		Employee a = dao.save(emp);
		mail.mailSent(emp.getMailID(), msg);

	}

	public void deleteDAO(int empId) {
		Employee emp1 = getEmployeeByIdService(empId);
		String mailId = emp1.getMailID();
		String msg = "You were Fired From JMI";
		dao.deleteById(empId);
		mail.mailSent(mailId, msg);

	}

	public List<Employee> getAllEmployee() {

		return (List<Employee>) dao.findAll();
	}

	public Employee getEmployeeByIdService(int empId) {
		return dao.findById(empId).get();

	}

	public Employee updateEmployee(Employee emp) {
		Optional<Employee> employee = dao.findById(emp.getEmpID());
		Map<Object, Object> feilds = new HashMap();

		if (employee.isPresent()) {
			feilds.forEach((key, value) -> {
				Field field = ReflectionUtils.findField(Employee.class, (String) value);
				field.setAccessible(true);
				ReflectionUtils.setField(field, employee.get(), value);
			});
			return dao.save(emp);

		}
		return null;

	}

	void defaultuhh() {
		System.out.println("DEFAULT");
	}
}
