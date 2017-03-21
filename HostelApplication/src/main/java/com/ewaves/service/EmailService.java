package com.ewaves.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;
import java.util.Properties;
import java.util.UUID;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ewaves.domain.ResponseVO;
import com.ewaves.entities.HostelDetails;
import com.ewaves.entities.LoginDetails;
import com.ewaves.entities.Student;
import com.ewaves.entities.StudentRequest;
import com.ewaves.repository.PasswordTokenRepository;
import com.ewaves.repository.StudentRepository;
import com.ewaves.util.HttpStatusCode;
import com.ewaves.util.MailUI;

@Service
public class EmailService {

	@Autowired
	PasswordTokenRepository passwordTokenRepository;
	/*@Autowired
	private StudentService studentService;*/
	@Autowired
	private MailUI mailUI;
	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private PasswordTokenService PasswordTokenService;

	private static Properties props = null;
	{
		InputStream is = null;
		try {
			props = new Properties();
			is = this.getClass().getResourceAsStream("/emailserver.properties");
			if (is == null) {
				System.err.println("Error reading server configuration of the right files");
			}
			props.load(is);
			if (props == null) {
				System.err.println("error reading server configuration");
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

	private Session getEmailSession() {
		return Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(props.getProperty("mail.username"),
						props.getProperty("mail.password"));
			}
		});
	}

	public ResponseVO forgotPasswordMail(String email, HttpServletRequest request) {

		try {
			Student dbstudent = studentRepository.findByEmail(email);
			if (dbstudent == null) {
				// log.info("Invalid User Id" + user.getUserId());

				// return "redirect:/login.html?lang=" +
				// request.getLocale().getLanguage();
				return HttpStatusCode.NON_AUTHORITATIVE_INFORMATION.getResponseVO("FAILURE");
			}

			String token = UUID.randomUUID().toString();
			PasswordTokenService.createPasswordResetTokenForUser(dbstudent, token);
			final String appUrl = "http://" + request.getServerName() + ":" + request.getServerPort()
					+ request.getContextPath();
			MimeMessage message = constructResetTokenEmail(appUrl, request.getLocale(), token, dbstudent);
			Transport.send(message);

		} catch (final MessagingException mex) {
			System.err.println("exception occurred in sendemail" + mex.getMessage());

			// return "redirect:/emailError.html?lang=" +
			// request.getLocale().getLanguage();
		} catch (final Exception e) {

			// return "redirect:/login.html?lang=" +
			// request.getLocale().getLanguage();
		}
		// return "redirect:/login.html?lang=" +
		// request.getLocale().getLanguage();
		return HttpStatusCode.FOUND.getResponseVO("SUCCESS");
	}

	private final MimeMessage constructResetTokenEmail(final String contextPath, final Locale locale,
			final String token, final Student user) {

		Session session = getEmailSession();
		MimeMessage message = new MimeMessage(session);
		try {
			message.setFrom(new InternetAddress(props.getProperty("mail.username")));

			message.addRecipient(Message.RecipientType.TO, new InternetAddress(user.getEmail()));

			final String url = contextPath + "/changepassword?id=" + user.getId() + "&token=" + token;
			message.setSubject("Welcome to Cin-Cin Admin Panel", "UTF-8");
			message.setHeader("Content-Type", "text/plain; charset=UTF-8");
			String emailContentType = "text/html" + "; charset=UTF-8";
			StringBuilder content=mailUI.forgotPasswordTemplet(url,user.getUser().getUsername());
			//String content = "Please click below link for rest password" + " \r\n" + url;
			message.setContent(content.toString(), emailContentType);
		} catch (AddressException e) {
			System.out.println("In constructResetTokenEmail : \n" + e.getMessage());

		} catch (MessagingException e) {
			System.out.println("In constructResetTokenEmail : \n" + e.getMessage());
		}
		return message;
	}

	public MimeMessage sendStudentRequestMail(HostelDetails requestVO, StudentRequest studentRequest) {
		StringBuilder result = new StringBuilder();
		result.append("<p>Dear " + requestVO.getFirstName() + ",</p>");
		result.append(
				"<p>Request to Join in your hostel,if below profile are matched to your hostel please let me know&nbsp;</p>");
		result.append("<p>Name : " + studentRequest.getName() + ",<br />");
		result.append("Email :" + studentRequest.getEmail() + ",<br />");
		result.append("No of Beds :" + studentRequest.getNoOfBeds() + ",<br />");
		result.append("Sharing Perference :" + studentRequest.getSharingPerference() + ".</p>");
		result.append("<p>&nbsp;</p><p>&nbsp;</p>");
		result.append("<p>Regards, <br />" + studentRequest.getName() + ", <br />080-40945777</p>");
		String content = result.toString();
		Session session = getEmailSession();
		MimeMessage message = new MimeMessage(session);
		try {
			message.setFrom(new InternetAddress(props.getProperty("mail.username")));

			message.addRecipient(Message.RecipientType.TO, new InternetAddress(requestVO.getEmailId()));

			// final String url = contextPath + "/changepassword?id=" +
			// user.getId() + "&token=" + token;
			message.setSubject("ReqUest For Room Join", "UTF-8");
			message.setHeader("Content-Type", "text/plain; charset=UTF-8");
			String emailContentType = "text/html" + "; charset=UTF-8";
			/*
			 * String content = "Hi sir ," + " \r\n" +
			 * "i required a room in ur hostel with below requirments" + " \r\n"
			 * + "Name : " + requestVO.getFirstName() + " \r\n" + "Email" +
			 * requestVO.getEmailId() + " \r\n" + " Share Perference :" +
			 * studentRequest.getSharingPerference();
			 */
			message.setContent(content, emailContentType);
		} catch (AddressException e) {
			System.out.println("In constructResetTokenEmail : \n" + e.getMessage());

		} catch (MessagingException e) {
			System.out.println("In constructResetTokenEmail : \n" + e.getMessage());
		}

		return message;

	}

	public MimeMessage sendDetailsHostelManagerMail(HostelDetails details) {
		
		Session session = getEmailSession();
		MimeMessage message = new MimeMessage(session);
		try {
			message.setFrom(new InternetAddress(props.getProperty("mail.username")));

			message.addRecipient(Message.RecipientType.TO, new InternetAddress("mysore.charankumar@gmail.com"));

			// final String url = contextPath + "/changepassword?id=" +
			// user.getId() + "&token=" + token;
			message.setSubject("Request For Add hostel", "UTF-8");
			message.setHeader("Content-Type", "text/plain; charset=UTF-8");
			String emailContentType = "text/html" + "; charset=UTF-8";
			/*
			 * String content = "Hi sir ," + " \r\n" +
			 * "i required a room in ur hostel with below requirments" + " \r\n"
			 * + "Name : " + requestVO.getFirstName() + " \r\n" + "Email" +
			 * requestVO.getEmailId() + " \r\n" + " Share Perference :" +
			 * studentRequest.getSharingPerference();
			 */
			
			String content="jkljljk";
			message.setContent(content, emailContentType);
		} catch (AddressException e) {
			System.out.println("In constructResetTokenEmail : \n" + e.getMessage());

		} catch (MessagingException e) {
			System.out.println("In constructResetTokenEmail : \n" + e.getMessage());
		}

		return message;
	}

	public MimeMessage sendNewUserNametoHostelNamger(LoginDetails logindetails,String password,HttpServletRequest request) {
		
		Session session = getEmailSession();
		MimeMessage message = new MimeMessage(session);
		try {
			message.setFrom(new InternetAddress(props.getProperty("mail.username")));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(logindetails.getUsername()));
			message.setSubject("Request For Add hostel", "UTF-8");
			message.setHeader("Content-Type", "text/plain; charset=UTF-8");
			String emailContentType = "text/html" + "; charset=UTF-8";
			final String url = "http://" + request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath()+ "/#/home";
			String userNameTrim=logindetails.getUsername();
			String[] a=userNameTrim.split("@");
			System.out.println("-------------->"+a[0]);
			String content=mailUI.sendMailTemplet(url, logindetails.getUsername(),a[0]).toString();
			message.setContent(content, emailContentType);
		} catch (AddressException e) {
			System.out.println("In constructResetTokenEmail : \n" + e.getMessage());

		} catch (MessagingException e) {
			System.out.println("In constructResetTokenEmail : \n" + e.getMessage());
		}

		return message;
	}

	public MimeMessage sendStudentRegisterScusess(Student studentVO, HttpServletRequest request) {
		
		Session session = getEmailSession();
		MimeMessage message = new MimeMessage(session);
		try {
			message.setFrom(new InternetAddress(props.getProperty("mail.username")));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(studentVO.getEmail()));
			message.setSubject("Request For Add hostel", "UTF-8");
			message.setHeader("Content-Type", "text/plain; charset=UTF-8");
			String emailContentType = "text/html" + "; charset=UTF-8";
			final String url = "http://" + request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath()+ "/home";
			String content=mailUI.sendMailTemplet(url, studentVO.getEmail(),studentVO.getFirstName()).toString();
			message.setContent(content, emailContentType);
		} catch (AddressException e) {
			System.out.println("In constructResetTokenEmail : \n" + e.getMessage());

		} catch (MessagingException e) {
			System.out.println("In constructResetTokenEmail : \n" + e.getMessage());
		}

		return message;
	}

}
