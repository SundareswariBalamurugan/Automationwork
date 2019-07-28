Feature: Automating a public API holding Employee Details

#Automating a Public API using Jersey RESTful web Services in java
Background:
Given User has access to all employee details

@fetch @crud
Scenario: Validate whether user is able to fetch single employee details
When User fetches the single record
Then employee details shoud be retrieved succesfully

@Create @crud
Scenario: Validate whether user is able to create a new employee record
When User creates a new employee record in database
|name|salary|age|
|Sarah|123|26|
Then employee details should be saved successfully

@update @crud
Scenario: Validate whether user is able to update the new employee record
When user updates the details of the employee
Then employee details shoud be saved succesfully

@delete @crud
Scenario: Validate whether user is able to delete the created employee record
When user delete the existing employee
Then employee details should be deleted successfully
