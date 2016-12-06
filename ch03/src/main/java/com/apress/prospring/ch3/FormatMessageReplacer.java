package com.apress.prospring.ch3;

import java.lang.reflect.Method;

import org.springframework.beans.factory.support.MethodReplacer;

/**
 *
 * @param  arg0    bean, where basic method called
 * @param  method  Method instance, which is replaced method
 * @param  args    method parameters
 * @return         result of replaced method
 * 
 */
public class FormatMessageReplacer implements MethodReplacer {

	public Object reimplement(Object arg0, Method method, Object[] args)
			throws Throwable {

		// Is method being replaced
		if(isFormatMessageMethod(method)) {			
			
			// replacement logics			
			String msg = (String) args[0];			
			return "<h2>" + msg + "</h2>";
			
		} else {
			throw new IllegalArgumentException("Unable to reimplement method "
					+ method.getName());
		}		
	}
	
	// validate method
	private boolean isFormatMessageMethod(Method method) {
		if(method.getParameterTypes().length != 1){
			// less or more than 1 parameter of mehod
			return false;
		}
		if(!("formatMessage".equalsIgnoreCase(method.getName()))){
			// wrong name of method
			return false;			
		}
		if(method.getReturnType() != String.class){
			// return value of the method is not String
			return false;			
		}
		if(method.getParameterTypes()[0] != String.class){
			// parameter of the method is not String
		}
		
		return true; // If all is OK
	}

}
