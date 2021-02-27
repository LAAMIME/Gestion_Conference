package com.adnane;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.adnane.model.*;
import com.adnane.repo.AudienceRepository;
import com.adnane.repo.ConferenceRepository;
import com.adnane.repo.ThemeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.adnane.repo.UserRepository;
import com.adnane.services.AccountService;

@SpringBootApplication
@RestController
@CrossOrigin(origins = "*")
public class GestionConferenceApplication implements CommandLineRunner {
	@Autowired
    private UserRepository userRepository;
    @Autowired
    private RepositoryRestConfiguration restConfig;
    @Autowired
	AccountService accountService;
    @Autowired
    ThemeRepository themeRepository;
	@Autowired
	AudienceRepository audienceRepository;
    @Autowired
    ConferenceRepository conferenceRepository;
    
    
//    @RequestMapping("/user")
//    @ResponseBody
//	public Principal user(Principal user) {
//	  return user;
//	}
    
	public static void main(String[] args) {
		SpringApplication.run(GestionConferenceApplication.class, args);
	}
	
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
	    return new BCryptPasswordEncoder();
    }

	@Override
	public void run(String... args) throws Exception {
		restConfig.exposeIdsFor(Conference.class,Theme.class, Audience.class,AppUser.class,Chair.class);
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		Theme theme = new Theme("IA");
		Theme theme1 = new Theme("Deep Learning");
		Theme theme2 = new Theme("Machine Learning");
		themeRepository.save(theme);themeRepository.save(theme1);themeRepository.save(theme2);
		Audience audience = new Audience("level 1");
		Audience audience1 = new Audience("level 2");
		Audience audience2 = new Audience("level 3");
		audienceRepository.save(audience);audienceRepository.save(audience1);audienceRepository.save(audience2);
		Conference conference = new Conference("Conference AI","FSTS","Conference AI",new Date() , new Date(12/05/2020),new Date(12/05/2020), 20,theme,audience);
		Conference conference1 = new Conference("Conference Deep Learning","FSTS","Conference Deep Learning", new Date() , new Date(25/05/2020),new Date(25/05/2020), 60,theme1,audience1);
		Conference conference2 = new Conference("Conference Machine Learning","FSTS","Conference Machine Learning",new Date() , new Date(12/06/2020),new Date(12/06/2020), 40,theme2,audience2);
		conferenceRepository.save(conference);conferenceRepository.save(conference1);conferenceRepository.save(conference2);

		AppRole r1 = new AppRole("USER");
		AppRole r2 = new AppRole("ADMIN");
		AppRole r3 = new AppRole("CHAIR");
		AppRole r4= new AppRole("CP");
		
		accountService.saveRole(r1);
		accountService.saveRole(r2);
		accountService.saveRole(r3);
		accountService.saveRole(r4);
        
        accountService.saveUser("adnane", "em@g.com", true, "mdp1", "mdp1");
        accountService.saveUser("OTH", "OTH@jee.com", true, "OTHL", "OTHL");
        accountService.saveUser("hanane", "em@g.com", true,  "mdp3", "mdp3");
        accountService.saveUser("Imane", "em@g.com", false,  "mdp4", "mdp4");
       
        accountService.addRoleToUser("adnane", "ADMIN");
        accountService.addRoleToUser("OTH", "ADMIN");
       
        userRepository.findAll().forEach(u->{
        	System.out.println(u.getUsername() + ", " + u.isEstProf() + ":");
        	u.getRoles().forEach(r -> {
        		System.out.println(r);
        	});
        });
	}

}
