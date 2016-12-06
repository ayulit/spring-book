package com.apress.prospring4.ch4;

import org.springframework.beans.factory.BeanCreationException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

// Bean with 2 dependencies
public class SimpleBean {

	private static final String DEFAULT_NAME = "Luke Skywalker";
	
	// dependancy #1
	private String name;
	
	// dependancy #2
	private int age = Integer.MIN_VALUE;
	
	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	// initialization callback method
	public void init() throws IllegalAccessException{
		System.out.println("Initializing bean");
		if (name == null) {
			System.out.println("Using default name");
			name = DEFAULT_NAME;
		}
		if (age == Integer.MIN_VALUE) {
			throw new IllegalAccessException("You must set the age property of any beans of type "
					+ SimpleBean.class);
		}
	}
	
	public String toString() {
		return "Name: " + name + "\nAge: " + age;
	}
	
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("META-INF/spring/app-context-xml.xml");
		ctx.refresh();
		
		SimpleBean simpleBean1 = getBean("simpleBean1", ctx);
		SimpleBean simpleBean2 = getBean("simpleBean2", ctx);
        SimpleBean simpleBean3 = getBean("simpleBean3", ctx);
		
	}

	private static SimpleBean getBean(String beanName, ApplicationContext ctx) {
		try {
			SimpleBean bean = (SimpleBean) ctx.getBean(beanName);
			System.out.println(bean);
			return bean;
		} catch (BeanCreationException ex) {
			System.out.println("An error occured in bean configuration: "
					+ ex.getMessage());
			return null;	
		}
		
		
	}

}
