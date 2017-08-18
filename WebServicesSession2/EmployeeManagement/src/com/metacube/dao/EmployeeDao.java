package com.metacube.dao;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.metacube.model.Employee;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;


public class EmployeeDao {
	List<Employee> employeeList = new ArrayList<Employee>();
	
	public void writeToFile(List<Employee> employeeList){
		try(
			FileWriter file = new FileWriter("C://Users/User21/workspace/EmployeeManagement/details.JSON",true);	
			BufferedWriter bw = new BufferedWriter(file);
			PrintWriter out = new PrintWriter(bw)){
			ObjectMapper mapper = new ObjectMapper();
			for(Employee temp : employeeList){
			String jsonInString = mapper.writeValueAsString(temp);	
			out.println(jsonInString);
		}
		
		}catch(Exception e){
			
		}
	}
	
	public void writeAfterDelete(List<JSONObject> employeeList){
		try(
				FileWriter file = new FileWriter("C://Users/User21/workspace/EmployeeManagement/details.JSON");	
				BufferedWriter bw = new BufferedWriter(file);
				PrintWriter out = new PrintWriter(bw)){
				ObjectMapper mapper = new ObjectMapper();
				for(JSONObject temp : employeeList){
				String jsonInString = mapper.writeValueAsString(temp);	
				out.println(jsonInString);
			}
			}catch(Exception e){
				
			}
	}
	
	public List<JSONObject> readFromFile() throws org.json.simple.parser.ParseException{
		JSONParser parser = new JSONParser();
		JSONObject obj = null;
		List<JSONObject> list = new ArrayList<JSONObject>();
		try {
		List<String> l = new ArrayList<String>();
		l = Files.readAllLines(Paths.get("C://Users/User21/workspace/EmployeeManagement/details.JSON"));
		for (String s : l) {
		obj = (JSONObject) parser.parse(s);
		list.add((JSONObject) obj);
		}
		}catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
		return list;
	}
	
	public List<Employee> getList() throws org.json.simple.parser.ParseException{
		readFromFile();
		return employeeList;
	}
	
}
