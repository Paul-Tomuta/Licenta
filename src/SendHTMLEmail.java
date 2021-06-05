import java.util.Properties;
import javax.mail.Message;

import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendHTMLEmail {
	
	private static final String SMTP_SERVER = "mail.it-labs.ro";
    private static final String USERNAME = "paul.tomuta@it-labs.ro";
    private static final String PASSWORD = "123#ITLabs";

    private static final String EMAIL_FROM = "paul.tomuta@it-labs.ro";
    private static final String EMAIL_TO = "paultomuta@gmail.com";
    private static final String EMAIL_TO_CC = "";

    private static final String EMAIL_SUBJECT = "Test Send Email via SMTP";
    private static final String EMAIL_TEXT = "Hello Java Mail \n ABC123";
    
    
	public void send_email() {


//	       Assuming you are sending email through relay.jangosmtp.net
	      String host = "relay.jangosmtp.net";

	      Properties props = System.getProperties();
	      
	      props.put("mail.smtp.host", SMTP_SERVER); //optional, defined in SMTPTransport
	      props.put("mail.smtp.auth", "true");
	      props.put("mail.smtp.port", "587"); // default port 25
	      props.put("mail.smtp.starttls.enable", "false");


	 //      Get the Session object.
	      Session session = Session.getInstance(props,
	         new javax.mail.Authenticator() {
	            protected PasswordAuthentication getPasswordAuthentication() {
	               return new PasswordAuthentication(USERNAME, PASSWORD);
	            }
		});

	      try {
	 //           Create a default MimeMessage object.
	            Message message = new MimeMessage(session);

	 //  	   Set From: header field of the header.
		   message.setFrom(new InternetAddress(EMAIL_FROM));

		//    Set To: header field of the header.
		   message.setRecipients(Message.RecipientType.TO,
	              InternetAddress.parse(EMAIL_TO));

	//	    Set Subject: header field
		   message.setSubject("Testing Subject");
	//	    Send the actual HTML message, as big as you like
		   message.setContent(
	              "<h1>This is actual message embedded in HTML tags</h1>",
	             "text/html");

		//    Send message
		   Transport.send(message);

		   System.out.println("Sent message successfully....");

	      } catch (MessagingException e) {
		   e.printStackTrace();
		   throw new RuntimeException(e);
	      }
	   }

}
