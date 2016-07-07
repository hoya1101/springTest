package main.java.com.sap;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class MavenSandbox {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		
		HelloWorld obj = (HelloWorld) context.getBean("helloWorld");

	    obj.printMessage();
	   
	}
	
	public String hello(){
		return "Hello world";
	}
}
