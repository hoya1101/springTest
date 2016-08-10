package main.java.com.sap;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;

@Named  
public class HelloWorld implements BeanNameAware, BeanFactoryAware{

	@NotBlank
	// @Size(min = 10, message = "at least 10 char needed!")
	// @Pattern(regexp = "^(\\+)?(\\d{2,3})?(\\s)?(\\d{11})$", message =
	// "invalid phone number")
	private String message;
	
	@Autowired
	private User user;
	
	private BeanFactory               beanFactory;

	//@Size(min = 10, message = "at least 10 char needed!")
	//@Resource
	private String testMin = null;
	
	@Pattern(regexp = "^(\\+)?(\\d{2,3})?(\\s)?(\\d{11})$", message = "invalid phone number")
	private String phone = null;
	
	//@Resource
	private String injectTest;
	
	public String getUserName(){
		return this.user.getName();
	}
	public BeanFactory getBeanFactory(){
		return this.beanFactory;
	}
	private String beanName; 

	private String withoutInjection;

	//@Required  // only be applied in setter
	public void setTestMin(String min) {
		this.testMin = min;
		System.out.println("setTestMin called: " + min);
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public void setPhone(String phone){
		System.out.println("Phone setter called");
		this.phone = phone;
	}

	public HelloWorld() {
		System.out.println("in constructor");
	}

	public void printMessage() {
		System.out.println("Your Message : " + message);
	}

	public void setBeanName(String name) {
		this.beanName = name; 
		System.out.println("Hello, setBean name: ................." + name);
	}

	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		this.beanFactory = beanFactory;
	}
	
	public void setuser(User user){
		this.user = user;
	}
}
