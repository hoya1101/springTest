package main.java.com.sap;

import javax.annotation.Resource;
import javax.validation.constraints.Null;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

public class HelloWorld {

	@NotBlank
	// @Size(min = 10, message = "at least 10 char needed!")
	// @Pattern(regexp = "^(\\+)?(\\d{2,3})?(\\s)?(\\d{11})$", message =
	// "invalid phone number")
	private String message;

	@Size(min = 10, message = "at least 10 char needed!")
	private String testMin = null;
	
	@Pattern(regexp = "^(\\+)?(\\d{2,3})?(\\s)?(\\d{11})$", message = "invalid phone number")
	private String phone = null;
	
	@Resource
	private String injectTest;

	private String withoutInjection;

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
}
