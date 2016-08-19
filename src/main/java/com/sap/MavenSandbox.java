package com.sap;

import java.net.URL;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import com.sap.aop.Durid;
import com.sap.bean.Level10Durid;

import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.aop.framework.adapter.DefaultAdvisorAdapterRegistry;
import org.springframework.aop.framework.adapter.MethodBeforeAdviceInterceptor;
import org.springframework.aop.target.HotSwappableTargetSource;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScanBeanDefinitionParser;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.XmlWebApplicationContext;

// Jerry 2016-08-07 16:11PM - this interface should be applied in interface
// Jerry 2016-08-07 16:37PM - @Component - does not work
// Jerry 2016-08-15 17:25PM - https://www.mkyong.com/spring/spring-aop-examples-advice/

@Component
public class MavenSandbox implements BeanFactoryAware, BeanPostProcessor {

	private BeanFactory beanFactory;

	public BeanFactory getBeanFac() {
		return this.beanFactory;
	}

	public static void main(String[] args) {
		AbstractApplicationContext d = null;
		FactoryBean e = null;
		// URL url = MavenSandbox.class.getResource("beans2.xml"); // ok
		
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		System.out.println("calling getBean...");
		//HelloWorld obj = (HelloWorld) context.getBean("helloWorld");
		
		// Object object = obj.getBeanFactory().getBean("helloWorld");
		//System.out.println("Name : " + obj.getUserName());
		//HelloWorld proxy = (HelloWorld) context.getBean("helloWorldProxy");
		Object proxy = context.getBean("helloWorldProxy");
		System.out.println("name: " + proxy.getClass().getCanonicalName());
		//proxy.printMessage();
		Durid durid = (Durid)proxy;
		durid.castFire(5);
		durid.castStorm();
		AbstractAutowireCapableBeanFactory a = null;
		DefaultListableBeanFactory b = null;
		ComponentScanBeanDefinitionParser c = null;

		// http://stackoverflow.com/questions/24386771/javax-validation-validationexception-hv000183-unable-to-load-javax-el-express
		// performValidation(obj);

		/*
		 * XmlWebApplicationContext is the default implementation of interface WebApplicationContext, used as IoC container.
		 */
		XmlWebApplicationContext h  = null;
		
		
		testSwap(context);
		
		System.out.println("THE END");
	}

	static public void testSwap(ApplicationContext context){
		HotSwappableTargetSource swapper = (HotSwappableTargetSource) context.getBean("swapper");
		Object swapable = context.getBean("swappable");
		Durid level1Durid = (Durid)swapable;
		level1Durid.castStorm();

		swapper.swap(new Level10Durid());
		level1Durid.castStorm();
	}
	static public void anotherWayToGetBean() {
		// Jerry 2016-08-09 16:50PM another approach
		ClassPathResource res = new ClassPathResource("beans.xml");
		XmlBeanFactory fac = new XmlBeanFactory(res);
		Object another = fac.getBean("helloWorld");

		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(fac);
		reader.loadBeanDefinitions(res);
	}

	static public void performValidation(HelloWorld obj) {
		obj.setMessage(null);
		obj.setTestMin("i042416");
		obj.setTestMin("");
		
		ValidatorFactory vf = Validation.buildDefaultValidatorFactory();
		Validator validator = vf.getValidator();
		Set<ConstraintViolation<HelloWorld>> set = validator.validate(obj);
		System.out.println("Total number of violations: " + set.size());
		for (ConstraintViolation<HelloWorld> constraintViolation : set) {
			System.out.println(constraintViolation.getMessage());
			System.out.println(constraintViolation.getPropertyPath());
		}
	}

	public String hello() {
		return "Hello world";
	}

	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		this.beanFactory = beanFactory;
	}

	public Object postProcessBeforeInitialization(Object bean, String beanName)
			throws BeansException {
		//System.out.println("preProcessBeforeInitialization: " + beanName);
		return bean;
	}

	public Object postProcessAfterInitialization(Object bean, String beanName)
			throws BeansException {
		//System.out.println("postProcessAfterInitialization: " + beanName);
		return bean;
	}
}
