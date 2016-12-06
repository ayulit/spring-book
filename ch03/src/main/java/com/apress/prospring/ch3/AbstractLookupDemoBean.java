package com.apress.prospring.ch3;

import com.apress.prospring.ch3.DemoBean;
import com.apress.prospring.ch3.MyHelper;

//This class uses Method Injection for getting instance of MyHelper
public abstract class AbstractLookupDemoBean implements DemoBean {

	public abstract MyHelper getMyHelper();

	public void someOperation() {
		getMyHelper().doSomethingHelpful();
	}

}
