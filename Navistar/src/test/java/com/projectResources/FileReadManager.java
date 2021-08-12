package com.projectResources;

public class FileReadManager {
	 private static FileReadManager fileReaderManager = new FileReadManager();
	 private static PageObjects Pageobjects;
	 
	 private FileReadManager() {
	 }
	 
	 public static FileReadManager getInstance( ) {
	       return fileReaderManager;
	 }
	 
	 public PageObjects Locators() {
	 return (Pageobjects == null) ? new PageObjects() : Pageobjects;
  }
}
