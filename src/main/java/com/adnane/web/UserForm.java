package com.adnane.web;

public class UserForm {

	private String username;
	private String email;
	private boolean estProf;
	private String password;
	private String repassword;
	
	public UserForm(String username, String email, boolean estProf, String password, String repassword) {
		
		this.username = username;
		this.email = email;
		this.setEstProf(estProf);
		this.password = password;
		this.repassword = repassword;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRepassword() {
		return repassword;
	}

	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean getEstProf() {
		return estProf;
	}

	public void setEstProf(boolean estProf) {
		this.estProf = estProf;
	}
	
	
}
