package com.apress.prospring4.ch4;

import java.util.Locale;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MessageSourceDemo {

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("META-INF/spring/app-context-xml.xml");
		ctx.refresh();
		
		Locale english = Locale.ENGLISH;
		Locale russian = new Locale("ru", "RU");
		
		/** 
		 * getMessage gets message from ApplicationContext for the locale specified
		 * */ 
		System.out.println(ctx.getMessage("msg", null, english));
		System.out.println(ctx.getMessage("msg", null, russian));
		
		System.out.println(ctx.getMessage("nameMsg", new Object[] {"Perry","Rhodan"}, english));

	}

}
