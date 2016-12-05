package com.apress.prospring.ch3;

import org.springframework.context.support.GenericXmlApplicationContext;

public class DeclareSpringComponents {

	public static void main(String[] args) {

		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		
		ctx.load("META-INF/spring/app-context-annotation.xml");
		ctx.refresh();
		
		MessageRenderer messageRenderer = ctx.getBean("messageRenderer",
				MessageRenderer.class);
		
		messageRenderer.render();
		

	}

}
