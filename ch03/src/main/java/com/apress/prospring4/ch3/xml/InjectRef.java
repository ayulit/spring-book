package com.apress.prospring4.ch3.xml;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.apress.prospring.ch3.Oracle;

public class InjectRef {
	private Oracle oracle;
	
	public void setOracle(Oracle oracle) {
		this.oracle = oracle;
	}

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("META-INF/spring/app-context-xml.xml");
		ctx.refresh();
		
		InjectRef injectRef =
				(InjectRef) ctx.getBean("injectRef");
		
		System.out.println(injectRef);		

	}
	
	public String toString(){
		return oracle.defineMeaningOfLife();
	}

}
