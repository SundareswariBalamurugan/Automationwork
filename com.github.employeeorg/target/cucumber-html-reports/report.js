$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("features/EmployeeDetails.feature");
formatter.feature({
  "line": 1,
  "name": "Automating a public API holding Employee Details",
  "description": "",
  "id": "automating-a-public-api-holding-employee-details",
  "keyword": "Feature"
});
formatter.background({
  "comments": [
    {
      "line": 3,
      "value": "#Automating a Public API using Jersey RESTful web Services in java"
    }
  ],
  "line": 4,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 5,
  "name": "User has access to all employee details",
  "keyword": "Given "
});
formatter.match({
  "location": "EmployeeDetailsStepDef.user_has_access_to_all_employee_details()"
});
formatter.result({
  "duration": 7357482400,
  "status": "passed"
});
formatter.scenario({
  "line": 8,
  "name": "Validate whether user is able to fetch single employee details",
  "description": "",
  "id": "automating-a-public-api-holding-employee-details;validate-whether-user-is-able-to-fetch-single-employee-details",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 7,
      "name": "@fetch"
    },
    {
      "line": 7,
      "name": "@crud"
    }
  ]
});
formatter.step({
  "line": 9,
  "name": "User fetches the single record",
  "keyword": "When "
});
formatter.step({
  "line": 10,
  "name": "employee details shoud be retrieved succesfully",
  "keyword": "Then "
});
formatter.match({
  "location": "EmployeeDetailsStepDef.user_fetches_the_single_record()"
});
formatter.result({
  "duration": 918953300,
  "status": "passed"
});
formatter.match({
  "location": "EmployeeDetailsStepDef.employee_details_shoud_be_retrieved_succesfully()"
});
formatter.result({
  "duration": 83269400,
  "status": "passed"
});
formatter.background({
  "comments": [
    {
      "line": 3,
      "value": "#Automating a Public API using Jersey RESTful web Services in java"
    }
  ],
  "line": 4,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 5,
  "name": "User has access to all employee details",
  "keyword": "Given "
});
formatter.match({
  "location": "EmployeeDetailsStepDef.user_has_access_to_all_employee_details()"
});
formatter.result({
  "duration": 5906785900,
  "status": "passed"
});
formatter.scenario({
  "line": 13,
  "name": "Validate whether user is able to create a new employee record",
  "description": "",
  "id": "automating-a-public-api-holding-employee-details;validate-whether-user-is-able-to-create-a-new-employee-record",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 12,
      "name": "@Create"
    },
    {
      "line": 12,
      "name": "@crud"
    }
  ]
});
formatter.step({
  "line": 14,
  "name": "User creates a new employee record in database",
  "rows": [
    {
      "cells": [
        "name",
        "salary",
        "age"
      ],
      "line": 15
    },
    {
      "cells": [
        "Sarah",
        "123",
        "26"
      ],
      "line": 16
    }
  ],
  "keyword": "When "
});
formatter.step({
  "line": 17,
  "name": "employee details should be saved successfully",
  "keyword": "Then "
});
formatter.match({
  "location": "EmployeeDetailsStepDef.user_creates_a_new_employee_record_in_database(DataTable)"
});
formatter.result({
  "duration": 1065181000,
  "status": "passed"
});
formatter.match({
  "location": "EmployeeDetailsStepDef.employee_details_should_be_saved_successfully()"
});
formatter.result({
  "duration": 5570424300,
  "status": "passed"
});
formatter.background({
  "comments": [
    {
      "line": 3,
      "value": "#Automating a Public API using Jersey RESTful web Services in java"
    }
  ],
  "line": 4,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 5,
  "name": "User has access to all employee details",
  "keyword": "Given "
});
formatter.match({
  "location": "EmployeeDetailsStepDef.user_has_access_to_all_employee_details()"
});
formatter.result({
  "duration": 5921714300,
  "status": "passed"
});
formatter.scenario({
  "line": 20,
  "name": "Validate whether user is able to update the new employee record",
  "description": "",
  "id": "automating-a-public-api-holding-employee-details;validate-whether-user-is-able-to-update-the-new-employee-record",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 19,
      "name": "@update"
    },
    {
      "line": 19,
      "name": "@crud"
    }
  ]
});
formatter.step({
  "line": 21,
  "name": "user updates the details of the employee",
  "keyword": "When "
});
formatter.step({
  "line": 22,
  "name": "employee details shoud be saved succesfully",
  "keyword": "Then "
});
formatter.match({
  "location": "EmployeeDetailsStepDef.user_updates_the_details_of_the_employee()"
});
formatter.result({
  "duration": 967339100,
  "status": "passed"
});
formatter.match({
  "location": "EmployeeDetailsStepDef.employee_details_shoud_be_saved_succesfully()"
});
formatter.result({
  "duration": 6974400,
  "status": "passed"
});
formatter.background({
  "comments": [
    {
      "line": 3,
      "value": "#Automating a Public API using Jersey RESTful web Services in java"
    }
  ],
  "line": 4,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 5,
  "name": "User has access to all employee details",
  "keyword": "Given "
});
formatter.match({
  "location": "EmployeeDetailsStepDef.user_has_access_to_all_employee_details()"
});
formatter.result({
  "duration": 5964277200,
  "status": "passed"
});
formatter.scenario({
  "line": 25,
  "name": "Validate whether user is able to delete the created employee record",
  "description": "",
  "id": "automating-a-public-api-holding-employee-details;validate-whether-user-is-able-to-delete-the-created-employee-record",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 24,
      "name": "@delete"
    },
    {
      "line": 24,
      "name": "@crud"
    }
  ]
});
formatter.step({
  "line": 26,
  "name": "user delete the existing employee",
  "keyword": "When "
});
formatter.step({
  "line": 27,
  "name": "employee details should be deleted successfully",
  "keyword": "Then "
});
formatter.match({
  "location": "EmployeeDetailsStepDef.user_delete_the_existing_employee()"
});
formatter.result({
  "duration": 953856800,
  "status": "passed"
});
formatter.match({
  "location": "EmployeeDetailsStepDef.employee_details_should_be_deleted_successfully()"
});
formatter.result({
  "duration": 168100,
  "status": "passed"
});
});