package com.sap.util;

import java.util.ArrayList;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

class Staff {

	public Staff(String c){
		this.setCanthisAlsobeSerialized(c);
	}
	private String name;
	private String canthisAlsobeSerialized;
	public String getCanthisAlsobeSerialized() {
		return canthisAlsobeSerialized;
	}
	private void setCanthisAlsobeSerialized(String canthisAlsobeSerialized) {
		this.canthisAlsobeSerialized = canthisAlsobeSerialized;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public BigDecimal getSalary() {
		return salary;
	}
	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}
	public List<String> getSkills() {
		return skills;
	}
	public void setSkills(List<String> skills) {
		this.skills = skills;
	}
	private int age;
	private String position;
	private BigDecimal salary;
	private List<String> skills;

	//getters and setters
}

public class UtilTest{
	
	private Staff createDummyObject() {

		Staff staff = new Staff("i042416");

		staff.setName("mkyong");
		staff.setAge(33);
		staff.setPosition("Developer");
		staff.setSalary(new BigDecimal("7500"));

		List<String> skills = new ArrayList<String>();
		skills.add("java");
		skills.add("python");

		
		staff.setSkills(skills);

		return staff;

	}

	private void testJson(){
		ObjectMapper mapper = new ObjectMapper();

		Staff staff = createDummyObject();

		try {
			// Convert object to JSON string and save into a file directly
			mapper.writeValue(new File("c:\\temp\\staff.json"), staff);

			// Convert object to JSON string
			String jsonInString = mapper.writeValueAsString(staff);
			System.out.println(jsonInString);

			// Convert object to JSON string and pretty print
			jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(staff);
			System.out.println(jsonInString);

		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] arg){
		UtilTest url = new UtilTest();
		url.testJson();
	}
}