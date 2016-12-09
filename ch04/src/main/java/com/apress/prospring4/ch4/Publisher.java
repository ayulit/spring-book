package com.apress.prospring4.ch4;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 	Class-publisher of an event
 * */
public class Publisher implements ApplicationContextAware {

	private ApplicationContext ctx;
	
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		this.ctx = applicationContext;		
	}
	
	private void publish(String message) {
		ctx.publishEvent(new MessageEvent(this, message));		
	}
	
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("META-INF/spring/app-context-xml.xml");
		
		// publisher got itself from ApplicationContext!
		Publisher pub = (Publisher) ctx.getBean("publisher");
		
		// publisher publishes 2 events FOR ApplicationContext (that's why 'this' used)
		pub.publish("Hello World!");
		pub.publish("Fire in the hole!");

	}



}
