package main.java.com.sap.aop;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

public class BeForeMethodInjector implements MethodBeforeAdvice{

	public void before(Method method, Object[] args, Object target)
			throws Throwable {
	        System.out.println("HijackBeforeMethod : Before method hijacked!");
	}
}
