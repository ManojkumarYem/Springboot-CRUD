package com.crud.mail;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class Mail {

	private JavaMailSender mailSender;

	public Mail(JavaMailSender mailSender) {
		System.out.println("JavaMailSender object created");
		this.mailSender = mailSender;
	}

	public void mailSent(String to, String msg) {

		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(to);
		message.setSubject("Notification From JMI");
		message.setText(msg);
		mailSender.send(message);
		System.out.println("Mail sent Successfully");
	}

}
