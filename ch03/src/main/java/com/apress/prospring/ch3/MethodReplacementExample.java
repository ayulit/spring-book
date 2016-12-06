package com.apress.prospring.ch3;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.util.StopWatch;

public class MethodReplacementExample {

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("META-INF/spring/app-context-xml.xml");
		ctx.refresh();
		
		ReplacementTarget replacementTarget = 
				(ReplacementTarget) ctx.getBean("replacementTarget");
		ReplacementTarget standartTarget = 
				(ReplacementTarget) ctx.getBean("standartTarget");
		
		displayInfo(replacementTarget); // replaced method 
		displayInfo(standartTarget);    // method w/o substitution

	}

	private static void displayInfo(ReplacementTarget target) {
		
		System.out.println(target.formatMessage("Hello World!"));

		StopWatch stopWatch = new StopWatch();
		stopWatch.start("perfTest"); // timer started (Spring!)
		
		// which of beans is faster
		for (int x = 0; x < 100000; x++) {
			// so method called many times
			String out = target.formatMessage("foo");
		}
		
		stopWatch.stop();
		
		System.out.println("100000 invocations took: "
				+ stopWatch.getTotalTimeMillis() + " ms");
		
	}

}
