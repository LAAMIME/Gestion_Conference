package com.adnane.web;

import com.adnane.model.*;
import com.adnane.repo.*;
import com.adnane.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin("*")
public class ConferenceController {
    @Autowired
    private ThemeRepository themeRepository;
    @Autowired
    private AccountService accountService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AudienceRepository audienceRepository;
    @Autowired
    private ConferenceRepository conferenceRepository;

    @RequestMapping(value = "/editConferences/{id}",method = RequestMethod.PUT)
    public Conference modifier(@PathVariable Long id,@RequestBody Conference conference)
    {
        System.out.println("------------------****************************NUUUUUL"+conference.getDescription());
        System.out.println("------------------****************************NUUUUUL");
        System.out.println("------------------****************************NUUUUUL");
        System.out.println("------------------****************************NUUUUUL");
        System.out.println("------------------****************************NUUUUUL");

        conference.setId(id);
        return conferenceRepository.save(conference);
    }

    @RequestMapping(value = "/conferences/{id}",method = RequestMethod.GET)
    public Conference getContact(@PathVariable Long id)
    {
        return conferenceRepository.findById(id).get();
    }
    @PostMapping("/addConference")
    public Conference addChair(@RequestBody Conference conference ){
//        Conference c=obj;
        List<AppUser> cp=new ArrayList<AppUser>();
        Long idTheme = conference.getIdTheme();
        Long idAudience = conference.getIdAudience();
        List<String> commite = null;
        commite=conference.getList();
        System.out.println("------------------****************************NUUUUUL");
        System.out.println("------------------****************************NUUUUUL");
        System.out.println("------------------****************************NUUUUUL");
        System.out.println("------------------****************************NUUUUUL");
        System.out.println("------------------****************************NUUUUUL");
        System.out.println("------------------****************************NUUUUUL");
        System.out.println("------------------****************************");
        System.out.println(commite.size()+"------------------****************************"+idTheme);
        System.out.println("------------------****************************"+idAudience);
        commite.size();
        commite.forEach(u->{
            System.out.println(u+"------------------****************************");
            AppUser user=userRepository.findByUsername(u);
            accountService.addRoleToUser(userRepository.findByUsername(u).getUsername(), "CP");
            cp.add(userRepository.findByUsername(u));
        });
        conference.setCommitte(cp);
        System.out.println(commite.size()+"------------------****************************"+idTheme);
        System.out.println("------------------****************************"+idAudience);
        Theme theme = themeRepository.findById(idTheme).get();
        Audience audience = audienceRepository.findById(idAudience).get();
        conference.setTheme(theme);
        conference.setAudience(audience);
        conference.setCreationDate(new Date());
         /*System.out.println(theme);
       Conference conference1 = new Conference(conference.getTitle(),conference.getAdresse(),conference.getDescription(),conference.getStartDate()
                , conference.getEndDate(),conference.getPaperSubmissionlimitDate(), conference.getNbrPlaces(),theme);*/
        return conferenceRepository.save(conference);
    }

    @PutMapping("/updateConference")
    public Conference updateConference(@RequestBody Conference conference ){
//        Conference c=obj;
        List<AppUser> cp=new ArrayList<AppUser>();
        Long idTheme = conference.getIdTheme();
        Long idAudience = conference.getIdAudience();
        System.out.println(idTheme+"------------------****************************"+idAudience);
        List<String> commite = null;
        commite=conference.getList();
        commite.forEach(u->{
            System.out.println(u+"------------------****************************");
            AppUser user=userRepository.findByUsername(u);
            accountService.addRoleToUser(userRepository.findByUsername(u).getUsername(), "CP");
            cp.add(userRepository.findByUsername(u));
        });
        conference.setId(conference.getId());
        conference.setCommitte(cp);
        Theme theme = themeRepository.findById(idTheme).get();
        Audience audience = audienceRepository.findById(idAudience).get();
        conference.setTheme(theme);
        conference.setAudience(audience);
        conference.setCreationDate(new Date());
        conference.toString();
        conference.toString();
        conference.toString();
        conference.toString();
         /*System.out.println(theme);
       Conference conference1 = new Conference(conference.getTitle(),conference.getAdresse(),conference.getDescription(),conference.getStartDate()
                , conference.getEndDate(),conference.getPaperSubmissionlimitDate(), conference.getNbrPlaces(),theme);*/
        return conferenceRepository.save(conference);
    }
}
