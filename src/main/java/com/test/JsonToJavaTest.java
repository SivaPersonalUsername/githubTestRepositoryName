package com.test;

import java.io.IOException;

import com.beans.Employee;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonToJavaTest {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
ObjectMapper objectMapper=new ObjectMapper();

String employeeJsonStr="{\"name\":\"Ram\",\"city\":\"Bangalore\",\"designation\":\"SSE\"}";

try {
	
	
	Employee employee=objectMapper.readValue(employeeJsonStr, Employee.class);
	System.out.println("JsonToJavaTest");
	System.out.println(employee);
	
} catch (JsonParseException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} catch (JsonMappingException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}


	}
}
