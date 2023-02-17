package com.example.demo.exception;

import java.util.Date;

public class ErrorMessage {

	public ErrorMessage(int statusCode, String message, Date date, String description) {
		super();
		this.statusCode = statusCode;
		this.message = message;
		this.date = date;
		this.description = description;
	}
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int statusCode;
	public String message;
	public Date date;
	public String description;
}
