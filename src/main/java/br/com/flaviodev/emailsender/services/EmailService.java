package br.com.flaviodev.emailsender.services;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
	public void send(String name, String emailAddress, String subject, String message) {
		try {
			Email email = new SimpleEmail();
			email.setHostName("smtp.googlemail.com");
			email.setSmtpPort(465);
			email.setAuthenticator(new DefaultAuthenticator("appflaviodev@gmail.com", "xxxxxx"));
			email.setSSLOnConnect(true);

			email.setFrom("appflaviodev@gmail.com");
			email.setSubject(subject);
			email.setMsg(message);
			email.addTo(emailAddress);
			email.send();

		} catch (EmailException e) {
			e.printStackTrace();
		}
	}
}
