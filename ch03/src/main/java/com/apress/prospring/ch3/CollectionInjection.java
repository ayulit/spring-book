package com.apress.prospring.ch3;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.springframework.context.support.GenericXmlApplicationContext;

public class CollectionInjection {
	
	private Map<String, Object> map;
	private Properties props;
	private Set set;
	private List list;

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("META-INF/spring/app-context-xml.xml");
		ctx.refresh();
		CollectionInjection instance = 
				(CollectionInjection) ctx.getBean("injectCollection");
		instance.displayInfo();

	}
	
	public void setList(List list) {
		this.list = list;
	}
	
	public void setSet(Set set) {
		this.set = set;
	}

	public void setMap(Map<String, Object> map) {
		this.map = map;
	}

	public void setProps(Properties props) {
		this.props = props;
	}
	
	public void displayInfo() {
		System.out.println("Map contents:");		
		for(Map.Entry<String, Object> entry: map.entrySet()){
			System.out.println("Key: " + entry.getKey() +
					        " - Value: " + entry.getValue());
		}
		
		System.out.println("\nProperties contents:");
		for(Map.Entry<Object, Object> entry: props.entrySet()){
			System.out.println("Key: " + entry.getKey() +
					        " - Value: " + entry.getValue());		
		
		}
	
		System.out.println("\nSet contents:");
		for (Object obj: set) {
			System.out.println("Value: " + obj);
		}
		
		System.out.println("\nList contents:");
		for (Object obj: list) {
			System.out.println("List: " + obj);
		}

	} // displayInfo

}
