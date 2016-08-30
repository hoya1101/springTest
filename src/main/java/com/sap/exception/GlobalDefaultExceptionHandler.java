package com.sap.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

public class GlobalDefaultExceptionHandler extends
		SimpleMappingExceptionResolver {

	public GlobalDefaultExceptionHandler(){
		System.out.println("GlobalDefaultExceptionHandler constructor called!");
	}
	@Override
	public String buildLogMessage(Exception ex, HttpServletRequest request) {
        return "Spring MVC exception: " + ex.getLocalizedMessage();
    }
}