package com.apress.prospring4.ch4;


import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Properties;
import java.util.regex.Pattern;

import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.context.support.GenericXmlApplicationContext;

public class PropertyEditorBean {
	
	private byte[] bytes;            // Byte Array Property Editor
	private Class cls;               // Class Editor
	private Boolean trueOrFalse;     // Custom Boolean Editor
	private List<String> stringList; // Custom Collection Editor
	private Date date; 				 // Custom Date Editor
	private Float floatValue; 		 // Custom Number Editor
	private File file; 				 // File Editor
	private InputStream stream; 	 // Input Stream Editor
	private Locale locale;			 // Locale Editor
	private Pattern pattern;         // Pattern Editor
	private Properties properties;	 // Properties Editor
	private String trimString;		 // String Trimmer Editor
	private URL url;				 // URL Editor


	
	public static void main(String[] args) throws Exception {
		// creating file in C:\Users\{USERNAME}\AppData\Local\Temp\
		File file = File.createTempFile("test", "txt");
		file.deleteOnExit(); // deleting this file on exit
		
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		
		ctx.load("META-INF/spring/app-context-xml.xml");		
		ctx.refresh();
		
		PropertyEditorBean bean = (PropertyEditorBean) ctx.getBean("builtInSample");

	}
	
	/*
	 * class implements Spring IF for explicit register some Editors (e.g. StringTrimmerEditor)
	 * */
	public static class CustomPropertyEditorRegistrar implements PropertyEditorRegistrar {

		public void registerCustomEditors(PropertyEditorRegistry registry) {
			SimpleDateFormat dateFormatter = new SimpleDateFormat("MM/dd/yyyy");
			
			// it's just for formatting
			registry.registerCustomEditor(Date.class, 
					new CustomDateEditor(dateFormatter, true));
			
			// it's obligatorily for StringTrimmerEditor!
			registry.registerCustomEditor(String.class, 
					new StringTrimmerEditor(true));
			
		}		
	}

	
	/*
	 * 
	 * SETTERS BELOW
	 * 
	 * */
	
	public void setBytes(byte[] bytes) {
		System.out.println("1) Adding " + bytes.length + " bytes");
		this.bytes = bytes;
	}	
	
	public void setCls(Class cls) {
		System.out.println("2) Setting class: " + cls.getName());
		this.cls = cls;
	}

	public void setDate(Date date) {
		System.out.println("3) Setting date: " + date);
		this.date = date;
	}

	public void setFloatValue(Float floatValue) {
		System.out.println("4) Setting float value: " + floatValue);
		this.floatValue = floatValue;
	}

	public void setFile(File file) {
		System.out.println("5) Setting file: " + file.getName());
		this.file = file;
	}

	public void setLocale(Locale locale) {
		System.out.println("6) Setting locale: " + locale.getDisplayName());
		this.locale = locale;
	}
	
	public void setPattern(Pattern pattern) {
		System.out.println("7) Setting pattern (for regexp): " + pattern);
		this.pattern = pattern;
	}

	public void setProperties(Properties properties) {
		System.out.println("8) Loaded " + properties.size() + " properties");
		this.properties = properties;
	}
	
	public void setStream(InputStream stream) {
		System.out.println("9) Setting stream: " + stream);
		this.stream = stream;
	}
	
	public void setStringList(List<String> stringList) {
		System.out.println("10) Setting string list with size: " + stringList.size());
		this.stringList = stringList;
		
		for (String string: stringList) {
			System.out.println(" StringList member: " + string);
		}
	}

	public void setTrimString(String trimString) {
		System.out.println("11) Setting trim string: " + trimString);
		this.trimString = trimString;
	}
	
	public void setTrueOrFalse(Boolean trueOrFalse) {
		System.out.println("12) Setting Boolean: " + trueOrFalse);
		this.trueOrFalse = trueOrFalse;
	}

	public void setUrl(URL url) {
		System.out.println("13) Setting URL: " + url.toExternalForm());
		this.url = url;
	}


}
