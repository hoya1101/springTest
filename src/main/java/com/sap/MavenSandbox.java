package main.java.com.sap;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScanBeanDefinitionParser;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

// Jerry 2016-08-07 16:11PM - this interface should be applied in interface

// Jerry 2016-08-07 16:37PM - @Component - does not work
/*
 * 我们加了@Component注解，在配置文件中需要配置component-scan扫描到这个类，
 * Spring容器会自动查询实现了BeanPostProcessor接口的实现类并执行该接口定义的方法。
 */
@Component
public class MavenSandbox implements BeanFactoryAware, BeanPostProcessor {

	private BeanFactory beanFactory;

	public BeanFactory getBeanFac() {
		return this.beanFactory;
	}

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");

		HelloWorld obj = (HelloWorld) context.getBean("helloWorld");
		// Object object = obj.getBeanFactory().getBean("helloWorld");
		System.out.println("Name : " + obj.getUserName());
		AbstractAutowireCapableBeanFactory a = null;
		DefaultListableBeanFactory b = null;
		ComponentScanBeanDefinitionParser c = null;

		// http://stackoverflow.com/questions/24386771/javax-validation-validationexception-hv000183-unable-to-load-javax-el-express
		// performValidation(obj);
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
