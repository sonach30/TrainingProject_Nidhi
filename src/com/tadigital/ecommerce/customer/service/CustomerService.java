package com.tadigital.ecommerce.customer.service;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
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
import javax.servlet.http.HttpSession;

import com.tadigital.ecommerce.customer.dao.CustomerDao;
import com.tadigital.ecommerce.customer.entity.Customer;

public class CustomerService {
	CustomerDao customerDao = new CustomerDao();

	// CHECKING STATUS FOR INSERT QUERY FOR CHECKING THE REGISTRATION PROCESS
	// SUCCESS
	public boolean registerCustomer(Customer customer) {

		// GETTING STATUS FOR INSERT QUERY FROM CUSTOMERDAO
		boolean status = customerDao.insertCustomer(customer);

		// IF REGISTRATION IS SUCCESSFUL THEN SEND A WELCOME MAIL
		if (status) {
			// SENDING A WELCOME MAIL
			sendRegisterMail(customer.getCust_fname() + " " + customer.getCust_lname(), customer.getCust_email());
		}

		// RETURNING THE STATUS
		return status;
	}

	// SENDING MAIL ON SUCCESSFUL RESGISTRATION
	public String sendRegisterMail(String name, String email) {
			
			String status = "NOT SENT";

			// MAIL SERVER CONFIGURATION
			Properties properties = new Properties();
			properties.put("mail.smtp.host", "smtp.gmail.com");
			properties.put("mail.smtp.socketFactory.port", "465");
			properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
			properties.put("mail.smtp.auth", "true");
			properties.put("mail.smtp.port", "465");
			
			//MAIL LOGIN CONFIGURATION
			InputStream inputStream = getClass().getResourceAsStream("Email.properties");
			try {
				properties.load(inputStream);
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
			String id = properties.getProperty("email_id");
			String password = properties.getProperty("email_password");

			// CONNECT TO MAIL SERVER
			Session session = Session.getDefaultInstance(properties, new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					
					return new PasswordAuthentication(id,password);
				}
			});
			
			try {
				// COMPOSE MESSAGE
				MimeMessage mimeMessage = new MimeMessage(session);
				mimeMessage.setFrom(new InternetAddress(id));
				mimeMessage.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
				
				MimeMultipart mp = new MimeMultipart();
				MimeBodyPart mbp1 = new MimeBodyPart();
				
				String msg = "Hi,<body bgcolor='white'>Dear <i>" + name + "</font></i>,<br/><br/>"
						+ "<img src='cid:image1'><br/><h2><font color='blue' font-family='Comic Sans MS'><b>Welcome to the our Family!!</b></font></h2>"
						+ "<br/><font color='cyan'>We are to glad to you have you on-board</font>"
						+ "<br/><br/><br/><font color='green'>Keep Updated by visiting the webpage regularly for new offers and discounts</font>"
						+ "<br/><br/><br/><font color='red'>Happy Shopping!!!<br/>TA Digital<br/><br/></font><img src='cid:image'></body>";
				
				mbp1.setContent(msg, "text/html");
				mp.addBodyPart(mbp1);

				mbp1 = new MimeBodyPart();
				DataSource fds = new FileDataSource(
						"D:/Trainee Engineer March 2019/workspace/TrainingProject_Nidhi/WebContent/images/logo.jpg");
				
				mbp1.setDataHandler(new DataHandler(fds));
				mbp1.setHeader("Content-ID", "<image>");
				mp.addBodyPart(mbp1);

				mbp1 = new MimeBodyPart();
				fds = new FileDataSource(
						"D:/Trainee Engineer March 2019/workspace/TrainingProject_Nidhi/WebContent/images/WELCOME.jpg");
				mbp1.setDataHandler(new DataHandler(fds));
				mbp1.setHeader("Content-ID", "<image1>");
				mp.addBodyPart(mbp1);

				mimeMessage.setContent(mp);

				// SEND MAIL
				Transport.send(mimeMessage);

				status = "SENT";
			} catch (MessagingException mex) {
				mex.printStackTrace();
			}

			return status;
	}
		
		
	
	// CHECKING THE STATUS FOR SELECT QUERY FOR CHECKING THE LOGIN PROCESS SUCCESS
	public boolean loginCustomer(Customer customer) {
		// GETTING STATUS FOR SELECT QUERY FROM CUSTOMERDAO
		boolean status = customerDao.selectCustomerByEmailAndPassword(customer);

		// RETURNING THE STATUS
		return status;
	}

	
	
	// CREATING COOKIE FOR LOGIN
	public boolean cookieLogin(Customer customer) {
		boolean status = customerDao.updateCookieTime(customer);
		return status;
	}

	
	// CHECKING COOKIE LAST LOGIN TIME
	public boolean directcookieLogin(Customer customer) {
		boolean status = customerDao.selectCookie(customer);
		return status;
	}

	//UPDATING THE CUSTOMER DETAILS
	public boolean updateCustomer(Customer customer) {
		// GETTING STATUS FOR SELECT QUERY FROM CUSTOMERDAO
		boolean status = customerDao.updateCustomerById(customer);

		
		// RETURNING THE STATUS
		return status;
	}

	//CHANGING PASSWORD
	public boolean updatePassword(Customer customer) {
		// GETTING STATUS FOR SELECT QUERY FROM CUSTOMERDAO
		boolean status = customerDao.updateCustomerPasswordById(customer);
		if (status) {
			// SENDING A WELCOME MAIL
			sendUpdatePasswordMail(customer.getCust_fname() + " " + customer.getCust_lname(), customer.getCust_email());
		}
		// RETURNING THE STATUS
		return status;
	}

	public String sendUpdatePasswordMail(String name, String email) {
		String status = "NOT SENT";

		// MAIL SERVER CONFIGURATION
		Properties properties = new Properties();
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.socketFactory.port", "465");
		properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.port", "465");

		//MAIL LOGIN CONFIGURATION
		InputStream inputStream = getClass().getResourceAsStream("Email.properties");
		try {
			properties.load(inputStream);
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		String id = properties.getProperty("email_id");
		String password = properties.getProperty("email_password");
		
		// CONNECT TO MAIL SERVER
		Session session = Session.getDefaultInstance(properties, new javax.mail.Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(id , password);
			}
		});
		
		try {
			// COMPOSE MESSAGE
			MimeMessage mimeMessage = new MimeMessage(session);
			mimeMessage.setFrom(new InternetAddress(id));
			mimeMessage.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
			MimeMultipart mp = new MimeMultipart();
			MimeBodyPart mbp1 = new MimeBodyPart();
			
			String msg = "Hi,<body bgcolor='white'>Dear <i>" + name + "</font></i>,<br/><br/>"
					+ "Your password has been changed successfully<br><font color='red'>Happy Shopping!!!<br/>TA Digital<br/><br/></font><img src='cid:image'></body>";
			
			mbp1.setContent(msg, "text/html");
			mp.addBodyPart(mbp1);

			mbp1 = new MimeBodyPart();
			DataSource fds = new FileDataSource(
					"D:/Trainee Engineer March 2019/workspace/TrainingProject_Nidhi/WebContent/images/logo.jpg");
			mbp1.setDataHandler(new DataHandler(fds));
			mbp1.setHeader("Content-ID", "<image>");
			mp.addBodyPart(mbp1);

			mbp1 = new MimeBodyPart();
			fds = new FileDataSource(
					"D:/Trainee Engineer March 2019/workspace/TrainingProject_Nidhi/WebContent/images/WELCOME.jpg");
			mbp1.setDataHandler(new DataHandler(fds));
			mbp1.setHeader("Content-ID", "<image1>");
			mp.addBodyPart(mbp1);

			mimeMessage.setContent(mp);

			// SEND MAIL
			Transport.send(mimeMessage);

			status = "SENT";
		} catch (MessagingException mex) {
			mex.printStackTrace();
		}

		return status;
	}

	// EXCEPTION
	public boolean exceptionCustomer(Customer customer, String exception) {
		
		boolean status = sendExceptionMail((customer.getCust_fname() + " " + customer.getCust_lname()), exception);

		return status;
	}

	// SENDING MAIL IF EXCEPTION TAKES PLACE
	public boolean sendExceptionMail(String name, String exception) {

		boolean status = false;

		// MAIL SERVER CONFIGURATION
		Properties properties = new Properties();
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.socketFactory.port", "465");
		properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.port", "465");

		//MAIL LOGIN CONFIGURATION
		InputStream inputStream = getClass().getResourceAsStream("Email.properties");
		try {
			properties.load(inputStream);
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		String id = properties.getProperty("email_id");
		String password = properties.getProperty("email_password");
		
		// CONNECT TO MAIL SERVER
		Session session = Session.getDefaultInstance(properties, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				
				return new PasswordAuthentication(id , password);
			}
		});
		
		try {
			// COMPOSE MESSAGE
			MimeMessage mimeMessage = new MimeMessage(session);
			mimeMessage.setFrom(new InternetAddress(id));
			mimeMessage.setRecipients(Message.RecipientType.TO, InternetAddress.parse("nidhich30@gmail.com"));
			MimeMultipart mp = new MimeMultipart();
			MimeBodyPart mbp1 = new MimeBodyPart();
			String msg = "Hi,<body bgcolor='white'>Dear <i>" + name + "</font></i>,<br/><br/>" + exception;
			mbp1.setContent(msg, "text/html");
			mp.addBodyPart(mbp1);

			mbp1 = new MimeBodyPart();
			DataSource fds = new FileDataSource(
					"D:/Trainee Engineer March 2019/workspace/TrainingProject_Nidhi/WebContent/images/logo.jpg");
			mbp1.setDataHandler(new DataHandler(fds));
			mbp1.setHeader("Content-ID", "<image>");
			mp.addBodyPart(mbp1);

			mbp1 = new MimeBodyPart();
			fds = new FileDataSource(
					"D:/Trainee Engineer March 2019/workspace/TrainingProject_Nidhi/WebContent/images/WELCOME.jpg");
			mbp1.setDataHandler(new DataHandler(fds));
			mbp1.setHeader("Content-ID", "<image1>");
			mp.addBodyPart(mbp1);

			mimeMessage.setContent(mp);

			// SEND MAIL
			Transport.send(mimeMessage);

			status = true;

		} catch (MessagingException mex) {
			mex.printStackTrace();
		}

		return status;
	}

	
	
	//CALLING MAIL FUNCTION
	public boolean contactQuery(String fn, String ln, String mes, String sub, String em) {
		
		boolean status = sendContactMail(fn, ln,mes, sub, em);
		return status;
	}

	
	//SENDING MAIL TO VENDOR FOR CUSTOMER QUERY
	public boolean sendContactMail(String fn, String ln, String mes, String sub, String em) {

		boolean status = false;

		// MAIL SERVER CONFIGURATION
		Properties properties = new Properties();
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.socketFactory.port", "465");
		properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.port", "465");

		//MAIL LOGIN CONFIGURATION
		InputStream inputStream = getClass().getResourceAsStream("Email.properties");
		try {
			properties.load(inputStream);
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		String id = properties.getProperty("email_id");
		String password = properties.getProperty("email_password");
		// CONNECT TO MAIL SERVER
		Session session = Session.getDefaultInstance(properties, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				
				return new PasswordAuthentication(id, password);
			}
		});
		
		try {
			// COMPOSE MESSAGE
			MimeMessage mimeMessage = new MimeMessage(session);
			mimeMessage.setFrom(new InternetAddress(id));
			mimeMessage.setRecipients(Message.RecipientType.TO, InternetAddress.parse(id));
			mimeMessage.setSubject(sub);
			
			MimeMultipart mp = new MimeMultipart();
			MimeBodyPart mbp1 = new MimeBodyPart();
			String msg = "Hi,<br><body bgcolor='white'><i>" +mes+ "</font></i>,<br/><br/>from"+ fn + " " + ln ;
			mbp1.setContent(msg, "text/html");
			mp.addBodyPart(mbp1);

			mbp1 = new MimeBodyPart();
			DataSource fds = new FileDataSource(
					"D:/Trainee Engineer March 2019/workspace/TrainingProject_Nidhi/WebContent/images/logo.jpg");
			mbp1.setDataHandler(new DataHandler(fds));
			mbp1.setHeader("Content-ID", "<image>");
			mp.addBodyPart(mbp1);

			mbp1 = new MimeBodyPart();
			fds = new FileDataSource(
					"D:/Trainee Engineer March 2019/workspace/TrainingProject_Nidhi/WebContent/images/WELCOME.jpg");
			mbp1.setDataHandler(new DataHandler(fds));
			mbp1.setHeader("Content-ID", "<image1>");
			mp.addBodyPart(mbp1);

			mimeMessage.setContent(mp);

			// SEND MAIL
			Transport.send(mimeMessage);

			status = true;

		} catch (MessagingException mex) {
			mex.printStackTrace();
		}

		if(status) {
			status = false;

			// MAIL SERVER CONFIGURATION
			Properties properties1 = new Properties();
			properties.put("mail.smtp.host", "smtp.gmail.com");
			properties.put("mail.smtp.socketFactory.port", "465");
			properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
			properties.put("mail.smtp.auth", "true");
			properties.put("mail.smtp.port", "465");
			
			//MAIL LOGIN CONFIGURATION
			InputStream inputStream1 = getClass().getResourceAsStream("Email.properties");
			try {
				properties.load(inputStream);
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
			String id1 = properties.getProperty("email_id");
			String password1 = properties.getProperty("email_password");
			
			// CONNECT TO MAIL SERVER
			Session session1 = Session.getDefaultInstance(properties1, new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					
					return new PasswordAuthentication(id1 , password1);
				}
			});
			
			try {
				// COMPOSE MESSAGE
				MimeMessage mimeMessage = new MimeMessage(session1);
				mimeMessage.setFrom(new InternetAddress(id1));
				mimeMessage.setRecipients(Message.RecipientType.TO, InternetAddress.parse(em));
				mimeMessage.setSubject(sub);
				
				MimeMultipart mp = new MimeMultipart();
				MimeBodyPart mbp1 = new MimeBodyPart();
				String msg = "Hi,<br><body bgcolor='white'><i>" +mes+ "</font></i>,<br/><br/>from"+ fn + " " + ln ;
				mbp1.setContent(msg, "text/html");
				mp.addBodyPart(mbp1);

				mbp1 = new MimeBodyPart();
				DataSource fds = new FileDataSource(
						"D:/Trainee Engineer March 2019/workspace/TrainingProject_Nidhi/WebContent/images/logo.jpg");
				mbp1.setDataHandler(new DataHandler(fds));
				mbp1.setHeader("Content-ID", "<image>");
				mp.addBodyPart(mbp1);

				mbp1 = new MimeBodyPart();
				fds = new FileDataSource(
						"D:/Trainee Engineer March 2019/workspace/TrainingProject_Nidhi/WebContent/images/WELCOME.jpg");
				mbp1.setDataHandler(new DataHandler(fds));
				mbp1.setHeader("Content-ID", "<image1>");
				mp.addBodyPart(mbp1);

				mimeMessage.setContent(mp);

				// SEND MAIL
				Transport.send(mimeMessage);

				status = true;

			} catch (MessagingException mex) {
				mex.printStackTrace();
			}

		}
			
		return status;
	}

}
