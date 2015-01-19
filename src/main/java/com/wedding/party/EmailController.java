package com.wedding.party;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.wedding.utils.Emailservice;

@ManagedBean(name = "emailController", eager = true)
@RequestScoped
public class EmailController {
	private String name="";
	private String email;
	private String phone;
	private String description;
	
	
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

	public void sendEmail(){
		System.out.println("welcome");
        StringBuilder sb=new StringBuilder();
        sb.append("Name :").append("").append(name).append("\n");
        sb.append("email :").append("\t").append(email).append("\n");
        sb.append("phone :").append("\t").append(phone).append("\n");
        sb.append("description :").append("\t").append(description).append("\n");
        name="";email="";description="";phone="";
		String[] to={"sivankumar86@gmail.com","gsivasankari2005@yahoo.co.in","sankarigovind.cse@gmail.com"};
		Emailservice.sendFromGMail(to, "Email from Wedding website", sb.toString());
		
	}
}
