package main.java.com.sap;

import javax.annotation.Resource;
import javax.validation.constraints.Null;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

public class HelloWorld {
	
	@NotBlank
	private String message;
	   
	   @Resource
	   private String injectTest;
	   
	   private String withoutInjection;

	   public void setMessage(String message){
	      this.message  = message;
	   }

	   public HelloWorld(){
		   System.out.println("in constructor");
	   }
	   
	   public void printMessage(){
	      System.out.println("Your Message : " + message);
	   }
	}
