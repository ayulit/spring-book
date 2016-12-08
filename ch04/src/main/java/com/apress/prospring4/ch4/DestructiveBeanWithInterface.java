package com.apress.prospring4.ch4;

import java.io.File;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.context.support.GenericXmlApplicationContext;

public class DestructiveBeanWithInterface {
	
	private File file;
	private String filePath;

	@PostConstruct
	public void afterPropertiesSet() throws Exception {
		System.out.println("Initializing Bean");
		
		if(filePath == null) {
			throw new IllegalArgumentException("You must specify the filePath property of "
					+ DestructiveBeanWithInterface.class);
		}
		
		this.file = new File(filePath);
		this.file.createNewFile();
		
		System.out.println("File exists: " + file.exists());

	}

	@PreDestroy
	public void destroy() {
		System.out.println("Destroying Bean");
		
		// attempt to delete file, created during beans's initialization
		if(!file.delete()){
			System.err.println("ERROR: failed to delete file.");
		}
		
		System.out.println("File exists: " + file.exists());
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("META-INF/spring/app-context-annotation.xml");
		ctx.registerShutdownHook();
		ctx.refresh();
		
		DestructiveBeanWithInterface bean = (DestructiveBeanWithInterface) ctx.getBean("destructiveBean");

	}

}
