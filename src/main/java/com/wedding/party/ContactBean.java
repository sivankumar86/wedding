package com.wedding.party;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

import com.wedding.utils.Emailservice;

@ManagedBean
@RequestScoped
public class ContactBean {
	
	private String name="";
	private String email;
	private String phone;
	private String description;
	private static int  pageVisit=1;
	
	
	
	public int getPageVisit() {
		BufferedWriter bw=null;
		File f=new File("/mnt/counter/counters.txt");
		pageVisit++;
		try{
		bw=new BufferedWriter(new FileWriter(f));
 	   bw.write(Integer.toString(pageVisit));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
			if(bw!=null){
				try {
					bw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return pageVisit;
	}

	public void setPageVisit(int pageVisit) {
		this.pageVisit = pageVisit;
	}

	public ContactBean(){
		System.out.println("contace cons called");
		BufferedReader bf=null;
		BufferedWriter bw=null;
       try {
    	   File f=new File("/mnt/counter/counters.txt");
    	   if(f.exists() && pageVisit <=2){
    		   bf=new BufferedReader(new FileReader(f));
    		   String s=bf.readLine();
		  if(s!=null && !s.trim().equals("")){
			  pageVisit=Integer.parseInt(s);
		  }
		  if(bf!=null){
			  bf.close(); 
		  }
    	   }
    	  
    	   } catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	

		
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
	

}
