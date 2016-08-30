package com.sap.exception;

// learn from this blog: http://www.journaldev.com/2651/spring-mvc-exception-handling-controlleradvice-exceptionhandler-handlerexceptionresolver

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

public class GlobalDefaultExceptionHandler extends
		SimpleMappingExceptionResolver {

	public GlobalDefaultExceptionHandler(){
		System.out.println("GlobalDefaultExceptionHandler constructor called!");
	}
	@Override
	public String buildLogMessage(Exception ex, HttpServletRequest request) {
		System.out.println("Exception caught by Jerry");
		ex.printStackTrace();
        return "Spring MVC exception: " + ex.getLocalizedMessage();
    }
}