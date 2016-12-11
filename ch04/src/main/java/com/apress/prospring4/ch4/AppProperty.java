package com.apress.prospring4.ch4;


/**
 * 		This class is needed to store all the properties of the app
 *      loaded from .properties file
 * */
public class AppProperty {
	private String applicationHome;
	private String userHome;

	public String getApplicationHome() {
		return applicationHome;
	}
	public void setApplicationHome(String applicationHome) {
		this.applicationHome = applicationHome;
	}
	public String getUserHome() {
		return userHome;
	}
	public void setUserHome(String userHome) {
		this.userHome = userHome;
	}
	
}
