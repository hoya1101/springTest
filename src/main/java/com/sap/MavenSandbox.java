package main.java.com.sap;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class MavenSandbox {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		
		HelloWorld obj = (HelloWorld) context.getBean("helloWorld");
		obj.setMessage("2");
	    obj.printMessage();
	    
	    alidatorFactory vf = Validation.buildDefaultValidatorFactory();
		Validator validator = vf.getValidator();
		Set<ConstraintViolation<Dog>> set = validator.validate(d);
		for (ConstraintViolation<Dog> constraintViolation : set) {
			System.out.println(constraintViolation.getMessage());
		}
	   
	}
	
	public String hello(){
		return "Hello world";
	}
}
