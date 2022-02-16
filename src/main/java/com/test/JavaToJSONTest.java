package com.test;

import java.io.File;
import java.io.IOException;

import com.beans.Employee;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JavaToJSONTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
ObjectMapper objectMapper=new ObjectMapper();
System.out.println("JavaToJSONTest");
Employee employee=new Employee("Ram", "Bangalore", "SSE");

try {
	//see the generated out put in the emp.json
	objectMapper.writeValue(new File("target/emp.json"), employee);
	
	//another method
	String employeStr=objectMapper.writeValueAsString(employee);
	System.out.println("employeStr   "+employeStr);
	
	
	
	
} catch (JsonGenerationException e) {
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
