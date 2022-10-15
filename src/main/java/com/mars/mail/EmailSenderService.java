package com.mars.mail;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

/**
 * @author Angel Ruiz
 * @version 1.0.0
 * date 14/10/22
 */
@Service
public class EmailSenderService {

	private final JavaMailSender javaMailSender;

	@Value("${spring.mail.username}")
	private String from;

	public EmailSenderService(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}

	public void sendMail(String to, String body, String subject) throws Exception {
		try {
			var mail = javaMailSender.createMimeMessage();
			var message = new MimeMessageHelper(mail, true);

			if (from.equals(""))
				from = "angel@mars.us";

			message.setFrom(from);
			message.setTo(to);
			message.setText(body, true);
			message.setSubject(subject);
			javaMailSender.send(mail);
		} catch (Exception e) {
			throw e;
		}

	}

}
