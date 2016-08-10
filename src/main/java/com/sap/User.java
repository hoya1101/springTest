package main.java.com.sap;

import javax.inject.Named;

import org.springframework.stereotype.Component;

@Named  
public class User {
	private String mName;
	public User(){
		System.out.println("User constructor called.........");
	}
	public void setmName(String name){
		System.out.println("User::setmName called: " + name);
		this.mName = name;
	}
	
	public String getName(){
		return this.mName;
	}
}
