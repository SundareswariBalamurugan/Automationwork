package com.github.employeeorg.dto;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.github.employeeorg.BaseModel;
/**
 * @author SUndareswari Sundaramahalingam
 * THIS POJO CLASS IS USED FOR GETTING/SETTING A JSON RESPONSE WITH FEW EMPLOYEE DETAILS
 * AND STORING EACH VALUE IN JSONPROPERTY
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"name",
"salary",
"age",
"id"
})
public class Employees extends BaseModel{


@JsonProperty("name")
private String name;
@JsonProperty("salary")
private String salary;
@JsonProperty("age")
private String age;
@JsonProperty("id")
private String id;


@JsonProperty("name")
public String getName() {
return name;
}

@JsonProperty("name")
public void setName(String name) {
this.name = name;
}

@JsonProperty("salary")
public String getSalary() {
return salary;
}

@JsonProperty("salary")
public void setSalary(String salary) {
this.salary = salary;
}

@JsonProperty("age")
public String getAge() {
return age;
}

@JsonProperty("age")
public void setAge(String age) {
this.age = age;
}

@JsonProperty("id")
public String getId() {
return id;
}

@JsonProperty("id")
public void setID(String id) {
this.id = id;
}

}