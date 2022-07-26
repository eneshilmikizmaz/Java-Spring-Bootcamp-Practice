package com.logo.dto;

public class EmailDto {

	private String toSend;
	private String title;
	private String email;

	public EmailDto(String toSend, String title, String email) {
		super();
		this.toSend = toSend;
		this.title = title;
		this.email = email;
	}

	public String getToSend() {
		return toSend;
	}

	public void setToSend(String toSend) {
		this.toSend = toSend;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
