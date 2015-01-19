package com.wedding.party;

import javax.faces.bean.ManagedBean;

@ManagedBean(name = "helloWorld", eager = true)
public class WeddingIntro {
	
	
	   public WeddingIntro() {
	      System.out.println("HelloWorld started!");
	   }
	   public String getMessage() {
	      return "Hello World!";
	   }
}
