package date;
import java.util.Properties;
import javax.mail.Message;

import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendEmail {

	private static final String SMTP_SERVER = "mail.it-labs.ro";
	private static final String USERNAME = "paul.tomuta@it-labs.ro";
	private static final String PASSWORD = "Parola#70";

	private static final String EMAIL_FROM = "paul.tomuta@it-labs.ro";
	private static  String EMAIL_TO ;
	private static final String EMAIL_TO_CC = "";

	private static  String EMAIL_SUBJECT ;
	private static  String EMAIL_TEXT ;
	
	private static String nume;
	private static String numeText;
	

	public SendEmail(String emailto, String subject, String text) {
		
		
		
		this.EMAIL_TO = emailto;
		this.EMAIL_SUBJECT=subject;
		this.EMAIL_TEXT=text;
		Properties props = System.getProperties();
		props.put("mail.smtp.host", SMTP_SERVER); 
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "587"); 
		props.put("mail.smtp.starttls.enable", "false");
		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				main.Main.logger.info("Parola acceptata");
				return new PasswordAuthentication(USERNAME, PASSWORD);
				
			}
		});

		try {			
			Message message = new MimeMessage(session);			
			message.setFrom(new InternetAddress(EMAIL_FROM));			
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(EMAIL_TO));
			message.setSubject(EMAIL_SUBJECT);			
			message.setContent(""+ EMAIL_TEXT, "text/html");  
			Transport.send(message);

		} catch (MessagingException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	

	public static void setEMAIL_TO(String eMAIL_TO) {
		EMAIL_TO = eMAIL_TO;
	}

	public static void setEMAIL_SUBJECT(String eMAIL_SUBJECT) {
		EMAIL_SUBJECT = eMAIL_SUBJECT;
	}

	public static void setEMAIL_TEXT(String eMAIL_TEXT) {
		EMAIL_TEXT = eMAIL_TEXT;
	}
	
	

}
