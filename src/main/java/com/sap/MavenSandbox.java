package main.java.com.sap;


import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class MavenSandbox {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		
		HelloWorld obj = (HelloWorld) context.getBean("helloWorld");
		obj.setMessage("2");
	    obj.printMessage();
	    
	    // http://stackoverflow.com/questions/24386771/javax-validation-validationexception-hv000183-unable-to-load-javax-el-express
	    ValidatorFactory vf = Validation.buildDefaultValidatorFactory();
		Validator validator = vf.getValidator();
		Set<ConstraintViolation<HelloWorld>> set = validator.validate(obj);
		for (ConstraintViolation<HelloWorld> constraintViolation : set) {
			System.out.println(constraintViolation.getMessage());
		}
	   
	}
	
	public String hello(){
		return "Hello world";
	}
}
