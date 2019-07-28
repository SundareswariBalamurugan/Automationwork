package com.github.employeeorg.stepdefs;

import java.util.List;

import com.github.employeeorg.servicestest.EmployeeDetailsApi;

import cucumber.api.DataTable;
import cucumber.api.java.en.*;

public class EmployeeDetailsStepDef {
	EmployeeDetailsApi employeeDetailsApi;
	
	
	public EmployeeDetailsStepDef(EmployeeDetailsApi employeeDetailsApi) {
		this.employeeDetailsApi = employeeDetailsApi;
	}

	@Given("^User has access to all employee details$")
	public void user_has_access_to_all_employee_details() throws Throwable {
		employeeDetailsApi.getEmployeeDetails();
	}

	@Then("^employee details shoud be retrieved succesfully$")
	public void employee_details_shoud_be_retrieved_succesfully() throws Throwable {
		employeeDetailsApi.getEmployeeID();
	}
	
		
	@When("^User fetches the single record$")
	public void user_fetches_the_single_record() throws Throwable {
		employeeDetailsApi.getSingleEmployeeDetail();
	}

	@Then("^User creates a new employee record in database$")
	public void user_creates_a_new_employee_record_in_database(DataTable newEmployee) throws Throwable {
	   List<List<String>> newEmpDetails = newEmployee.raw();
	   System.out.println(newEmpDetails.size());
	   employeeDetailsApi.createEmployeeRecord(newEmpDetails);
	}
	
	@Then("^employee details should be saved successfully$")
	public void employee_details_should_be_saved_successfully() throws Throwable {
		employeeDetailsApi.validateCreatedEmployeeDetails();
	}
		
	@When("^user updates the details of the employee$")
	public void user_updates_the_details_of_the_employee() throws Throwable {
		employeeDetailsApi.updateEmployeeDetails();
	}

	@Then("^employee details shoud be saved succesfully$")
	public void employee_details_shoud_be_saved_succesfully() throws Throwable {
		employeeDetailsApi.validatingUpdatedValues();
	}
	
	@When("^user delete the existing employee$")
	public void user_delete_the_existing_employee() throws Throwable {
		employeeDetailsApi.deleteNewRecord();
	}

	@Then("^employee details should be deleted successfully$")
	public void employee_details_should_be_deleted_successfully() throws Throwable {
		employeeDetailsApi.validateRecordIsDeleted();
	}


}
