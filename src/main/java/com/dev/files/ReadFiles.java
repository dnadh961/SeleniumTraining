package com.dev.files;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ReadFiles {

	private String browser;
	private String instaneUrl;
	private String username;
	private String password;
	private boolean fullScreen;
	private String resolution;
	
	private Properties prop;
	
	ReadFiles() throws IOException {
		FileReader reader=new FileReader("config.properties");  
		prop = new Properties();
		
		prop.load(reader);
		browser = prop.getProperty("browser");
		instaneUrl = prop.getProperty("test.instance");
		username = prop.getProperty("username");
		password = prop.getProperty("password");
		fullScreen = Boolean.valueOf(prop.getProperty("fullScreen"));
	}
	
	public String getBrowser() {
		return browser;
	}
	public String getInstaneUrl() {
		return instaneUrl;
	}
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	public boolean isFullScreen() {
		return fullScreen;
	}
	public String getResolution() {
		return resolution;
	}
	
	public static void main(String[] args) throws IOException {
		ReadFiles readFiles = new ReadFiles();
		System.out.println(readFiles.getBrowser());
		System.out.println(readFiles.getInstaneUrl());
		System.out.println(readFiles.getUsername());
		System.out.println(readFiles.getPassword());
		System.out.println(readFiles.isFullScreen());
	}
	
}
