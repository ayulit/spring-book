package com.apress.prospring.ch3;

// This class uses Setter Injection for getting instance of MyHelper
public class StandartLookupDemoBean implements DemoBean {

	private MyHelper myHelper;
	
	public void setMyHelper(MyHelper myHelper){
		this.myHelper = myHelper;
	}
	
	public MyHelper getMyHelper() {		
		return myHelper;
	}

	public void someOperation() {
		myHelper.doSomethingHelpful(); 

	}

}
