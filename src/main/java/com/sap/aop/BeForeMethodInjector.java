package com.sap.aop;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

public class BeForeMethodInjector implements MethodBeforeAdvice{

	public void before(Method method, Object[] args, Object target)
			throws Throwable {
	        System.out.println("HijackBeforeMethod : Before method hijacked! method name: " + method.getName());
	        for( int i = 0; i < args.length; i++){
	        	System.out.println("Argument[" + i + "]:" + args[i].toString());
	        }
	}
}
