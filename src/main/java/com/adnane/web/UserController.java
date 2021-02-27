package com.adnane.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.adnane.model.AppUser;
import com.adnane.model.Chair;
import com.adnane.model.Conference;
import com.adnane.repo.ChairRepository;
import com.adnane.repo.ConferenceRepository;
import com.adnane.repo.UserRepository;
import com.adnane.services.AccountService;

@RestController
@CrossOrigin("*")
public class UserController {
	
	@Autowired
	AccountService accountService;
	@Autowired
	UserRepository userRepository;
	@Autowired
	ConferenceRepository conferenceRepository;
	@Autowired
	ChairRepository chairRepository;

	@PostMapping("/register")
	public AppUser signUp(@RequestBody UserForm userForm) {
		String username = userForm.getUsername();
		String email = userForm.getEmail();
		boolean estProf = userForm.getEstProf();
		String password = userForm.getPassword();
		String repassword = userForm.getRepassword();
		return accountService.saveUser(username, email, estProf, password, repassword);
	}
	
//	@PostMapping("/chairConf")
//	public AppUser addChair(@RequestBody UserForm userForm) {
//		String username = userForm.getUsername();
//		String email = userForm.getEmail();
//		boolean estProf = userForm.getEstProf();
//		String password = userForm.getPassword();
//		String repassword = userForm.getRepassword();
//		return accountService.saveUser(username, email, estProf, password, repassword);
//	}
	
	@PostMapping("/chairConf")
	public Chair addChair(@RequestBody ChairConf chairConf ){
       System.out.println("------------------****************************");
       Long iduser = chairConf.getIduser();
       Long idconf = chairConf.getIdconf();
		AppUser user = userRepository.findById(iduser).get();
		Conference conf = conferenceRepository.findById(idconf).get();
		
		accountService.addRoleToUser(user.getUsername(), "CHAIR");
		return chairRepository.save(new Chair(user, conf));
  }
}
