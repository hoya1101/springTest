package com.sap.annotationBasedConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

@Configuration
//@Order(1)
public class DemoConfig2 {
	@Bean
	public Demo2Service demo2Service() {
		System.out.println("DemoConfig2 load...");
		return new Demo2Service();
	}
}