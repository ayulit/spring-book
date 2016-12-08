package com.apress.prospring4.ch4;

import java.security.MessageDigest;

import org.springframework.context.support.GenericXmlApplicationContext;

public class AccessingFactoryBeans {

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("META-INF/spring/app-context-xml.xml");		
		ctx.refresh();
		
		// direct access to beans Factory - try not to use it
		MessageDigestFactoryBean factoryBean = (MessageDigestFactoryBean) ctx.getBean("&shaDigest");
		
		try {
			// that is factory in action
			MessageDigest shaDigest = factoryBean.getObject();
			System.out.println(shaDigest.digest("Hello world".getBytes()));
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

}
