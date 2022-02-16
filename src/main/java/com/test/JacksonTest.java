package com.test;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.beans.Employee;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonTest {
	public static void main(String args[]){
		JacksonTest tester = new JacksonTest();
	         try {
	            ObjectMapper mapper = new ObjectMapper();

	            Map<String,Object> empDataMap = new HashMap<String,Object>(); 
	            int[] grades = {1,2,3};

	            Employee employee = new Employee("Ram1", "Bangalore1", "SSE1");
	            // JAVA Object
	            empDataMap.put("student", employee);
	            // JAVA String
	            empDataMap.put("name", "Mahesh Kumar");   		
	            // JAVA Boolean
	            empDataMap.put("verified", Boolean.FALSE);
	            // Array
	            empDataMap.put("grades", grades);

	            mapper.writeValue(new File("student.json"), empDataMap);
	            //result student.json
				//{ 
	            //   "student":{"name":"Mahesh","age":10},
	            //   "marks":[1,2,3],
	            //   "verified":false,
	            //   "name":"Mahesh Kumar"
	            //}
	            
	            
	            Map<String,Object> empDataMap1 = new HashMap<String,Object>(); 
	            empDataMap1 = mapper.readValue(new File("student.json"), Map.class);

	            System.out.println(empDataMap1.get("student"));
	            System.out.println(empDataMap1.get("name"));
	            System.out.println(empDataMap1.get("verified"));
	            System.out.println(empDataMap1.get("grades"));
	      } catch (JsonParseException e) {
	         e.printStackTrace();
	      } catch (JsonMappingException e) {
	         e.printStackTrace();
	      } catch (IOException e) {
	            e.printStackTrace();
	      }
	   }
}
