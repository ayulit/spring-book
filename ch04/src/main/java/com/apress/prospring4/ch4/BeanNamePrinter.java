package com.apress.prospring4.ch4;

import org.springframework.beans.factory.BeanNameAware;

public class BeanNamePrinter implements BeanNameAware {
	
	private String beanName;

	// will be called BEFORE ApplicationContext.getBean()
	public void setBeanName(String beanName) {
		this.beanName = beanName;
	}
	
	public void someOperation() {
		System.out.println("Bean [" + beanName + "] - someOperation()");
	}

}
