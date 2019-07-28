package com.github.employeeorg.utils;

import java.io.File;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Properties;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cucumber.api.Scenario;



public class Utils {

	private Properties props;
	private PropertyUtils propertyUtils;
	private static final Logger LOGGER = LoggerFactory.getLogger(Utils.class);
	private HashMap<String, Date> startTimes = new HashMap();
	private Scenario scenario;
	private String envName;
	private static final Random generator = new Random();
	
	
	
	public Utils() throws Throwable {
		propertyUtils = new PropertyUtils();
		envName = System.getProperty("env");
		LOGGER.info("Executing tests on: " + envName + " environment.");
		loadProperties(envName);
	}

	public void loadProperties(String envName) throws Throwable 
	{
		props = propertyUtils.getPropertiesForEnvironment(envName); 
		LOGGER.info("Property values: " + props);
	}

	public String getValueFromProperties(String key) {
		return props.getProperty(key);
	}
	
	
	
	public void setStartTimeForScenario(String scenarioName, Date startTime) 
	{
		startTimes.put(scenarioName, startTime);
	}
	
	public Date getStartTimeForScenario(String scenarioName)
	{
		Date startTime = null;
		if(startTimes.containsKey(scenarioName))
		{
			startTime =  startTimes.get(scenarioName);
		}	
		
		return startTime;
	}

	public void setScenario(Scenario currentScenario) 
	{
		this.scenario = currentScenario;
		if (LOGGER.isInfoEnabled())
		{
			LOGGER.info("setScenario() - Scenario Name: " + scenario.getName());
		}	
	}
	
	public Scenario getScenario()
	{
		return scenario;
	}
	
	public String getDateandTimeAsString() 
	{
		GregorianCalendar gcalendar = new GregorianCalendar();
		String date;
		String months[] = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", 
		         "Oct", "Nov", "Dec"};

		date = gcalendar.get(Calendar.DATE)
				+ months[gcalendar.get(Calendar.MONTH)]
				+ gcalendar.get(Calendar.YEAR)
				+ Integer.toString(gcalendar.get(Calendar.HOUR_OF_DAY))
				+ Integer.toString(gcalendar.get(Calendar.MINUTE))
				+ Integer.toString(gcalendar.get(Calendar.SECOND));
		
		return date;
	}
	
	public String getRandomAlphaString(int len) {
		String AB = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
		SecureRandom rnd = new SecureRandom();

		StringBuilder sb = new StringBuilder(len);
		for (int i = 0; i < len; i++)
			sb.append(AB.charAt(rnd.nextInt(AB.length())));
		return sb.toString();
	}
	
	public static int getRandomInteger(int max) {
		return (int) (Math.random() * max);
	}
}
