package main.java.com.sap;

import main.java.com.sap.bean.Employee;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class resourceAnnotationTest {
	public static void main(String[] args) {
		AbstractApplicationContext  context = new ClassPathXmlApplicationContext("appConfTest.xml");
		Employee employee = context.getBean(Employee.class);
		System.out.println(employee.getAddress().getCity());
		System.out.println(employee.getCompany().getCompName());		
		context.close();
	}
} 
