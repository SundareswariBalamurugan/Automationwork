package com.github.employeeorg;

import java.io.File;
import java.io.PrintWriter;

import com.google.gson.Gson;

/**
 * 
 * @author Sundareswari
 *THIS CLASS IS TO WRITE THE JSON IN FILE
 */
public class BaseModel {

	public void writeJSONToFile(String fileName) {
		try {
			String filePath = System.getProperty("user.dir") + "/" + fileName;
			File jsonFile = new File(filePath);
			Gson gson = new Gson();
			PrintWriter writer = new PrintWriter(jsonFile, "UTF-8");
			writer.println(gson.toJson(this));
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
