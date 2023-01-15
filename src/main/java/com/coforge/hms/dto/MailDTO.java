package com.coforge.hms.dto;

public class MailDTO {
   
   public final String MAIL_FROM = "thiounesaliou972@gmail.com";
	
   private long id;
	private String emailSubject;
	private String emailContent;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getEmailSubject() {
		return emailSubject;
	}
	public void setEmailSubject(String emailSubject) {
		this.emailSubject = emailSubject;
	}
	public String getEmailContent() {
		return emailContent;
	}
	public void setEmailContent(String emailContent) {
		this.emailContent = emailContent;
	}
	public String getMAIL_FROM() {
		return MAIL_FROM;
	}
	
	
	public MailDTO() {
		super();
	}
	
}
