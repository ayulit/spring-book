package com.apress.prospring4.ch4;

import java.beans.PropertyEditorSupport;

public class NamePropertyEditor extends PropertyEditorSupport {
	/*
	 * Transformes "John Smith" to Name class with John and Smith
	 * */
	
	// realization of method of PropertyEditor IF
	public void setAsText (String text) throws IllegalArgumentException {
		String[] name = text.split("\\s"); // split by space
		 
		setValue(new Name(name[0], name[1]));
		
	}

}
