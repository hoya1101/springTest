package main.java.com.sap;

public class HelloWorld {
	   private String message;

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
