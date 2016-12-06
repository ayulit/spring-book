package com.apress.prospring.ch3;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.util.StopWatch;

public class LookupDemo {

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("META-INF/spring/app-context-xml.xml");
		ctx.refresh();
		
		DemoBean abstractBean = 
				(DemoBean) ctx.getBean("abstractLookupBean");
		DemoBean standartBean = 
				(DemoBean) ctx.getBean("standartLookupBean");
		
		displayInfo(standartBean);
		displayInfo(abstractBean);

	}

	private static void displayInfo(DemoBean bean) {
		MyHelper helper1 = bean.getMyHelper();
		MyHelper helper2 = bean.getMyHelper();
		
		System.out.println(bean.getClass().getSimpleName());
		
		// == for standartBean: singleton!
		// != for abstractBean: each time new instance!	
		System.out.println("Helper Instances the Same?: "
				+ (helper1 == helper2)); 
		
		StopWatch stopWatch = new StopWatch();
		stopWatch.start("lookupDemo"); // timer started (Spring!)
		
		// which of beans is faster (must be standartBean i.e. singleton)
		for (int x = 0; x < 100000; x++) {
			MyHelper helper = bean.getMyHelper(); // creating many instances
			helper.doSomethingHelpful();
		}
		
		stopWatch.stop();
		
		System.out.println("100000 gets took "
				+ stopWatch.getTotalTimeMillis() + " ms");
		
	}

}
