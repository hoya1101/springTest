package main.java.com.sap;


import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

// Jerry 2016-08-07 16:11PM - this interface should be applied in interface

// Jerry 2016-08-07 16:37PM - @Component
@Component
public class MavenSandbox implements BeanFactoryAware{

	private BeanFactory               beanFactory;
	
	public BeanFactory getBeanFac(){
		return this.beanFactory;
	}
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		
		HelloWorld obj = (HelloWorld) context.getBean("helloWorld");
		Object  object = obj.getBeanFactory().getBean("helloWorld");
		obj.setMessage(null);
		obj.setTestMin("i042416");
		obj.setTestMin("");
	    //obj.printMessage();
	    
	    //obj.setTestMin(null);
	    
	    // http://stackoverflow.com/questions/24386771/javax-validation-validationexception-hv000183-unable-to-load-javax-el-express
	    ValidatorFactory vf = Validation.buildDefaultValidatorFactory();
		Validator validator = vf.getValidator();
		Set<ConstraintViolation<HelloWorld>> set = validator.validate(obj);
		System.out.println("Total number of violations: " + set.size());
		for (ConstraintViolation<HelloWorld> constraintViolation : set) {
			System.out.println(constraintViolation.getMessage());
			System.out.println(constraintViolation.getPropertyPath());
		}
	}
	
	public String hello(){
		return "Hello world";
	}

	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		this.beanFactory = beanFactory;
	}
}
