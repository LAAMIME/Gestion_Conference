package com.adnane.security;
import com.adnane.model.AppRole;
import com.adnane.model.AppUser;
import com.adnane.repo.UserRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService{

	@Autowired
	private UserRepository repo;
	
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		AppUser appuser = repo.findByUsername(username) ;
		
		if(appuser == null)
			throw new UsernameNotFoundException("User not found");
		
		Collection<GrantedAuthority> authorities = new ArrayList<>();
	    for (AppRole role : appuser.getRoles()){
	        authorities.add(new SimpleGrantedAuthority(role.getRole()));
	    }
		
		return new User(appuser.getUsername(), appuser.getPassword(), authorities);
	}
	 

}
