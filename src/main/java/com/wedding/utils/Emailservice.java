package com.wedding.utils;

import java.util.Properties;

import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class Emailservice {

	  private static String USER_NAME = "sivankumar86";  // GMail user name (just the part before "@gmail.com")
	    private static String PASSWORD = "6535navi&"; // GMail password
	    private static String RECIPIENT = "sivankumar86@gmail.com";
      //private long x =100_000;
	    public static void main(String[] args) {
	        String from = USER_NAME;
	        String pass = PASSWORD;
	        String[] to = { RECIPIENT }; // list of recipient email addresses
	        String subject = "Java send mail example";
	        String body = "Welcome to JavaMail!";

	       sendFromGMail(to, subject, body);
	    }

	    public static void sendFromGMail(String[] to, String subject, String body) {
	        Properties props = System.getProperties();
	        String host = "smtp.gmail.com";
	        props.put("mail.smtp.starttls.enable", "true");
	        props.put("mail.smtp.host", host);
	        props.put("mail.smtp.user", USER_NAME);
	        props.put("mail.smtp.password", PASSWORD);
	        props.put("mail.smtp.port", "587");
	        props.put("mail.smtp.auth", "true");
           System.out.println("send an email");
	        Session session = Session.getDefaultInstance(props);
	        MimeMessage message = new MimeMessage(session);

	        try {
	            message.setFrom(new InternetAddress(USER_NAME));
	            InternetAddress[] toAddress = new InternetAddress[to.length];

	            // To get the array of addresses
	            for( int i = 0; i < to.length; i++ ) {
	                toAddress[i] = new InternetAddress(to[i]);
	            }

	            for( int i = 0; i < toAddress.length; i++) {
	                message.addRecipient(Message.RecipientType.TO, toAddress[i]);
	            }
	           // message.addRecipient(Message.RecipientType.BCC,new InternetAddress(""));
	            message.setSubject(subject);
	            message.setText(body);
	            Transport transport = session.getTransport("smtp");
	            transport.connect(host, USER_NAME, PASSWORD);
	            transport.sendMessage(message, message.getAllRecipients());
	            transport.close();
	        }
	        catch (AddressException ae) {
	            ae.printStackTrace();
	        }
	        catch (MessagingException me) {
	            me.printStackTrace();
	        }
	    }
	}