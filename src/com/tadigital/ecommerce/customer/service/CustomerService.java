package com.tadigital.ecommerce.customer.service;


import java.io.File;
import java.util.Properties;
import java.lang.Object;

import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Part;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
//import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
//import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
//import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;




import com.tadigital.ecommerce.customer.dao.CustomerDao;
import com.tadigital.ecommerce.customer.entity.Customer;

public class CustomerService {
	CustomerDao customerDao = new CustomerDao();
	
	//CHECKING STATUS FOR INSERT QUERY FOR CHECKING THE REGISTRATION PROCESS SUCCESS
	public boolean registerCustomer(Customer customer) {
		
		boolean status = customerDao.insertCustomer(customer);
		if(status)
		{
			sendWelcomeMail(customer.getCust_fname() + " " + customer.getCust_lname(), customer.getCust_email());
		}
		
		return status;
	}
	
	
	//CHECKING THE STATUS FOR SELECT QUERY FOR CHECKING THE LOGIN PROCESS SUCCESS
	public boolean loginCustomer(Customer customer)
	{
		boolean status = customerDao.selectEmployeeByEmailAndPassword(customer);
		return status;
	}
	
	
	
	//SENDING MAIL ON SUCCESSFUL RESGISTRATION
	
	
	public String sendWelcomeMail(String name, String email) {
		String status = "NOT SENT";
		
		//MAIL SERVER CONFIGURATION
		Properties properties = new Properties();
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.socketFactory.port", "465");
		properties.put("mail.smtp.socketFactory.class",	"javax.net.ssl.SSLSocketFactory");
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.port", "465");
		
		//CONNECT TO MAIL SERVER
		Session session = Session.getDefaultInstance(properties,new javax.mail.Authenticator() {
																	protected PasswordAuthentication getPasswordAuthentication() {
																		return new PasswordAuthentication("nidhich30@gmail.com","09415882570");
																	}
																});
		try {
			//COMPOSE MESSAGE
			MimeMessage mimeMessage = new MimeMessage(session);
			//MimeMessageHelper helper = new MimeMessage(message, true);
			mimeMessage.setFrom(new InternetAddress("nidhich30@gmail.com"));
			mimeMessage.setRecipients(Message.RecipientType.TO,	InternetAddress.parse(email));
			MimeMultipart mp = new MimeMultipart();
			MimeBodyPart mbp1= new MimeBodyPart();
			String msg ="<body bgcolor='white'>Dear <i><font color='blue'>" + name + "</font></i>,<br/><br/>" +
					 "<img src='cid:image1'><br/><h2><font color='red'>Welcome to the GANG!!</font></h2>" +
					 "<br/><font color='cyan'>We are to glad to you have you on-board</font>" +
					 "<br/><br/><br/><font color='green'>Keep Updated by visiting the webpage regularly for new offers and discounts</font>" +
					 "<br/><br/><br/><font color='red'>Happy Ecommercing!!!<br/>TA Digital<br/><br/></font><img src='cid:image'></body>";
			mbp1.setContent(msg,"text/html");
			mp.addBodyPart(mbp1);
			
			mbp1 = new MimeBodyPart();
			DataSource fds = new FileDataSource("D:/Trainee Engineer March 2019/workspace/TrainingProject_Nidhi/WebContent/images/logo.png");
			mbp1.setDataHandler(new DataHandler(fds));
			mbp1.setHeader("Content-ID", "<image>");
			mp.addBodyPart(mbp1);
			
			mbp1 = new MimeBodyPart();
			fds = new FileDataSource("D:/Trainee Engineer March 2019/workspace/TrainingProject_Nidhi/WebContent/images/product1.jpg");
			mbp1.setDataHandler(new DataHandler(fds));
			mbp1.setHeader("Content-ID", "<image1>");
			mp.addBodyPart(mbp1);
				
			mimeMessage.setContent(mp);

			//SEND MAIL
			Transport.send(mimeMessage);
			
			status = "SENT";
		} catch (MessagingException mex) {
			mex.printStackTrace();
		}
		
		return status;
	}
}




