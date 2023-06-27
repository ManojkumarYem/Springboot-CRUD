package com.crud.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "employee")
public class Employee {

	@Id
	@GenericGenerator(name = "ref", strategy = "increment")
	@GeneratedValue(generator = "ref")
	private int empID;
	
	@Column(name = "name")
	@NotBlank(message = "Name must be not null")
	private String name;

	@Column(name = "age")
	@Min(value = 18, message = "Age must be above 18")
	@Max(value = 50, message = "Age must be below 50")
	private String age;
	
	@Column(name = "address")
	@NotEmpty(message = "Address must be not null")
	private String address;
	
	@Column(name = "mailID")
	@Email(message = "please give a valid mail-id")
	private String mailID;
	
	@OneToOne
	@PrimaryKeyJoinColumn
	private modelPojo pojo;

	public modelPojo getPojo() {
		return pojo;
	}

	public void setPojo(modelPojo pojo) {
		this.pojo = pojo;
	}

	public int getEmpID() {
		return empID;
	}

	public void setEmpID(int empID) {
		this.empID = empID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMailID() {
		return mailID;
	}

	public void setMailID(String mailID) {
		this.mailID = mailID;
	}
}
