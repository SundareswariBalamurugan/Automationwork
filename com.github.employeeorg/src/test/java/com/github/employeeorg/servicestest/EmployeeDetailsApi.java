package com.github.employeeorg.servicestest;

import java.lang.reflect.Type;
import java.util.List;

import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.employeeorg.BaseApi;
import com.github.employeeorg.dto.Employee;
import com.github.employeeorg.dto.Employees;
import com.github.employeeorg.utils.Utils;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;

/**
 * @author Sundareswari Sundaramahalingam
 * THIS CLASS IS TO PERFORM CRUD OPERATION OF EMPLOYEE
 * USING REST API REQUEST AND RESPONSE AND THE FRAMEWORK FOLLWED HERE IS
 * JERSEY REST FRAMEWORK
 * THIS CLASS EXTENDS BASEAPI IN ORDER TO USE THE HTTP METHODS
 */

public class EmployeeDetailsApi extends BaseApi {

	Utils utils;
	public int id, newId;
	Gson gson;
	Employees employees;
	String responseVal, name, salary, age;
	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeDetailsApi.class);

	public EmployeeDetailsApi(Utils utils, Employees employees) {
		this.utils = utils;
		gson = new Gson();
		this.employees = employees;
	}

	/**
	 * This method is to fetch all the employee records in database
	 */

	public void getEmployeeDetails() {
		String response, url, token;

		url = utils.getValueFromProperties("fetch_employees_details_URL");
		token = null;
		try {

			responseVal = get(url, token);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * This method is to fetch the employee ID of a particular employee
	 */

	public void getEmployeeID() {
		int recordNo;
		// recordNo value is to fetch particular employee row from DB
		recordNo = Integer.parseInt(utils.getValueFromProperties("employee_record_to_be_fetched"));
		try {
			Employee[] e = gson.fromJson(responseVal, Employee[].class);
			id = Integer.parseInt(e[recordNo].getId());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * this method is used to fetch all the values of a particular employee using
	 * employee ID
	 */
	public void getSingleEmployeeDetail() {
		String response, url, token;
		url = utils.getValueFromProperties("fetch_employee_detail_Url");
		token = null;
		try {
			response = get((url + id), token);
			LOGGER.info("employee record extracted is" + response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method is to create a new employee record using the data table provided
	 * by user
	 * 
	 * @param newEmpDetails
	 */
	public void createEmployeeRecord(List<List<String>> newEmpDetails) {
		String url;
		int rndmInt;
		url = utils.getValueFromProperties("create_employee_url");
		/*
		 * random no is created and added as suffix to name field since name field is
		 * unique in DB
		 */
		rndmInt = utils.getRandomInteger(1000);
		for (int i = 1; i < newEmpDetails.size(); i++) {
			name = (newEmpDetails.get(i).get(i - 1) + rndmInt);
			salary = newEmpDetails.get(i).get(i);
			age = newEmpDetails.get(i).get(i + 1);
			employees.setName(name);
			employees.setSalary(salary);
			employees.setAge(age);
		}
		try {
			employees = (Employees) post(url, employees);
			newId = Integer.parseInt(employees.getId());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method is to validate whether new employee is created successfully
	 */
	public void validateCreatedEmployeeDetails() {

		String response, url, token;
		url = utils.getValueFromProperties("fetch_employee_detail_Url");
		token = null;
		try {
			response = get((url + newId), token);
			LOGGER.info("employee record extracted is created" + response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method is to update the newly created employee with updated values
	 * provided in properties file
	 */
	public void updateEmployeeDetails() {
		String url, idVal, token = null;
		idVal = String.valueOf(newId);
		name = (utils.getValueFromProperties("up_name") + utils.getRandomInteger(1000));
		salary = utils.getValueFromProperties("up_salary");
		age = utils.getValueFromProperties("up_age");
		url = utils.getValueFromProperties("update_employee_url");
		employees.setName((name));
		employees.setSalary(salary);
		employees.setAge(age);
		employees.setID(idVal);
		try {
			employees = (Employees) put((url + newId), token, employees);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * this method is to validate the updated record from the database
	 */
	public void validatingUpdatedValues() {

		Assert.assertTrue("Values are not updated successfully", employees.getName().equalsIgnoreCase(name)
				&& employees.getSalary().equalsIgnoreCase(salary) && employees.getAge().equalsIgnoreCase(age));

	}

	/**
	 * This method is to delete the record created by the user
	 */
	public void deleteNewRecord() {
		String url, token = null;
		url = utils.getValueFromProperties("deleteUrl") + newId;
		try {
			responseVal = delete(token, (url));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method is to validate whether record is deleted successfully
	 */
	public void validateRecordIsDeleted() {

		Assert.assertTrue("records are not deleted", responseVal.contains("successfully! deleted Records"));

	}

}
