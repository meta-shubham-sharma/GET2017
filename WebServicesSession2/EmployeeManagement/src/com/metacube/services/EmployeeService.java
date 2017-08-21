package com.metacube.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import com.metacube.dao.EmployeeDao;
import com.metacube.model.Employee;

/**
 * @author shubham
 *
 */
@Path("/employeeService")
public class EmployeeService {

	EmployeeDao edao = new EmployeeDao();
	
	/**
	 * 
	 * @return list of employees	
	 * @throws ParseException
	 */
	@GET
	@Path("/employees")
	@Produces(MediaType.TEXT_PLAIN)
	public String getEmployees() throws ParseException{
		List<JSONObject> elist = edao.readFromFile();
		List<String> ls = new ArrayList<String>();
		for(JSONObject emp : elist){
		 ls.add( "Id : "+emp.get("id").toString() +" Name : " + emp.get("name").toString() +" Age : " + emp.get("age").toString() ); 
		}
		return ls.toString();
	}
	
	/**
	 * 
	 * @param id
	 * @param name
	 * @param age
	 * @param servletResponse
	 * @return string
	 * @throws IOException
	 * @throws ParseException
	 */
	@POST
	@Path("/employees/createEmployee/{id},{name},{age}")
	@Produces(MediaType.TEXT_PLAIN)
	public String createEmployee(@PathParam("id") String id,
		      @PathParam("name") String name,
		      @PathParam("age") String age,
		      @Context HttpServletResponse servletResponse) throws IOException, ParseException{
		Employee emp = new Employee();
		emp.setName(name);
		emp.setAge(age);
		emp.setId(id);
		List<Employee> elist = edao.getList();
		elist.add(emp);
		edao.writeToFile(elist);
		return "Employee is successfully created";
	}
	
	/**
	 * 
	 * @param id
	 * @return string
	 * @throws ParseException
	 */
	@GET
	@Path("/employees/getById/{id}")
	@Produces(MediaType.TEXT_PLAIN)
	public String getEmployeeById(@PathParam("id") String id) throws ParseException{
		List<JSONObject> employeeList = edao.readFromFile();
		for(JSONObject emp : employeeList){
			if(emp.get("id").toString().equals(id)){
				return "Id : "+emp.get("id").toString() +" Name : " + emp.get("name").toString() +" Age : " + emp.get("age").toString();
			}
		}
		return null;
	}
	
	/**
	 * 
	 * @param name
	 * @return string 
	 * @throws ParseException
	 */
	@GET
	@Path("/employees/getByName/{name}")
	@Produces(MediaType.TEXT_PLAIN)
	public String getEmployeeByName(@PathParam("name") String name) throws ParseException{
		List<JSONObject> employeeList = edao.readFromFile();
		List<String> ls = new ArrayList<String>();
		for(JSONObject emp : employeeList){
			if(emp.get("name").toString().equals(name)){
				ls.add( "Id : "+emp.get("id").toString() +" Name : " + emp.get("name").toString() +" Age : " + emp.get("age").toString() );
			}
		}
		return ls.toString();
	}

	/**
	 * 
	 * @param id
	 * @return string
	 * @throws ParseException
	 */
	@DELETE
	@Path("/employees/deleteById/{id}")
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteEmployeeById(@PathParam("id") String id) throws ParseException{
		List<JSONObject> employeeList = edao.readFromFile();
		for(JSONObject emp : employeeList){
			if(emp.get("id").toString().equals(id)){
				employeeList.remove(emp);
				edao.writeAfterDelete(employeeList);
				break;
			}
		}
		return "Employee is successfully deleted";
	}
}
