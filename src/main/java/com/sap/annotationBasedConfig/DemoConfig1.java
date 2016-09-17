package com.sap.annotationBasedConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

@Configuration
//@Order(2)
public class DemoConfig1 {
	@Bean
	public Demo1Service demo1Service() {
		System.out.println("DemoConfig1 .... load......");
		return new Demo1Service();
	}
}