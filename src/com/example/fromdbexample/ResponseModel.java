package com.example.fromdbexample;

public class ResponseModel {
	private String name;
	private String phone;
	private String response;

	public ResponseModel(String name, String phone, String response) {
		this.name = name;
		this.phone = phone;
		this.response = response;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

}
