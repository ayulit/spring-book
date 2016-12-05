package com.apress.prospring.ch3;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;

public class XmlConfigWithBeanFactory {

	public static void main(String[] args) {
		// one of the realizations of BeanFactory in Spring
		DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
		
		// use this to read info from XML
		XmlBeanDefinitionReader rdr = new XmlBeanDefinitionReader(factory);
		
		
		rdr.loadBeanDefinitions(new 
				ClassPathResource("META-INF/spring/xml-bean-factory-config.xml"));
		
		// here realization of BeanFactory has been created and configured 
		
		Oracle oracle = (Oracle) factory.getBean("oracle");
		
		System.out.println(oracle.defineMeaningOfLife());
		
	}

}
