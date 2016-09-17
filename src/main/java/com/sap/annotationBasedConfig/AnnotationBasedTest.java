package com.sap.annotationBasedConfig;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AnnotationBasedTest {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context =
			    new AnnotationConfigApplicationContext("com.sap.annotationBasedConfig");
		System.out.println("Bean definition count: " + context.getBeanDefinitionCount());
		try {
		Object bean1 = context.getBean("demo1Service");
		System.out.println(bean1.getClass().getName());
		Object bean2 = context.getBean("demo2Service");
		System.out.println(bean2.getClass().getName());
		BeanDefinition definition1 = context.getBeanDefinition("demo1Service");
		System.out.println("Bean class name: " + definition1.getBeanClassName());
		} catch(Exception e){
			System.out.println(e.getMessage());
		}
		
	}

}
