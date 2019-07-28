package com.github.employeeorg.runner;

import java.io.File;
import java.io.FileInputStream;

import org.apache.log4j.LogManager;
import org.apache.log4j.xml.DOMConfigurator;
import org.junit.runner.RunWith;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(jsonReport = "target/cucumber.json", retryCount = 0, detailedReport = true, detailedAggregatedReport = true, overviewReport = true, coverageReport = true, jsonUsageReport = "target/cucumber-usage.json", usageReport = true, toPDF = false, includeCoverageTags = {
		"@passed" }, outputFolder = "target")
@CucumberOptions(plugin = { "html:target/cucumber-html-reports", "json:target/cucumber.json",
		"pretty:target/cucumber-pretty.txt", "usage:target/cucumber-usage.json",
		"junit:target/cucumber-results.xml" }, features = "classpath:features", glue = "com/github/employeeorg", tags = {
				"@crud" })

public class RunnerClass extends AbstractTestNGCucumberTests {

	public RunnerClass() {
		String environment = "Input";

		if (System.getProperty("env") != null) {
			environment = System.getProperty("env");
		}

		System.setProperty("env", environment);
	}

}
