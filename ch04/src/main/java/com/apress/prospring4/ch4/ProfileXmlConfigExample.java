package com.apress.prospring4.ch4;

import java.util.List;

import org.springframework.context.support.GenericXmlApplicationContext;

public class ProfileXmlConfigExample {

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();		
		

		
		
		ctx.load("classpath:META-INF/spring/*-config.xml"); // BOTH (!) xml will be loaded

		/*	
		To Run in Eclipse do: Run Configurations.
		Click the Arguments tab and add -Dspring.profiles.active="kindergarten" at the end of VM arguments
		
		Or do the following below
		*/		
		// ctx.getEnvironment().setActiveProfiles("highschool"); // doesn't work in some reason
		
		ctx.refresh();
		
		FoodProviderService foodProviderService = ctx.getBean("foodProviderService", FoodProviderService.class);
		List<Food> lunchSet = foodProviderService.provideLunchSet();
		
		for (Food food: lunchSet) {
			System.out.println("Food: " + food.getName());
		}

	}

}
