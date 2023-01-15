package com.coforge.hms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.coforge.hms.dto.MailDTO;

@Service
public class EmailService {
	 private JavaMailSender javaMailSender;

	    @Autowired
	    public EmailService(JavaMailSender javaMailSender){
	        this.javaMailSender = javaMailSender;
	    }
	 
	 public void sendEmail(@RequestBody MailDTO email) throws MailException {
	        SimpleMailMessage mail = new SimpleMailMessage();
	        
	        mail.setFrom("thiounesaliou972@gmail.com");
	        mail.setTo("");
	        mail.setSubject(email.getEmailSubject());
	        mail.setText(email.getEmailContent());

	        javaMailSender.send(mail);
	    }
}
