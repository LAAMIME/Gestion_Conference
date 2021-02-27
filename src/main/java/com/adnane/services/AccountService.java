package com.adnane.services;

import com.adnane.model.AppRole;
import com.adnane.model.AppUser;

public interface AccountService {

	public AppUser saveUser(String username, String email, boolean estProf, String password, String repassword);
	public AppRole saveRole(AppRole r);
	public AppUser findUserByUsername(String username);
	public void addRoleToUser(String username, String role);
}
