package com.adnane.web;

import com.adnane.model.Chair;
import com.adnane.repo.ChairRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class ChairController {
    @Autowired
    private ChairRepository chairRepository;
    @RequestMapping(path = "/chercherConferenceByUser", method = RequestMethod.GET)
    public List<Chair> findConferenceByUser(@RequestParam(name = "idUser", defaultValue = "") Long idUser){
        System.out.println("::*********************************************::"+idUser);
        List<Chair> c = chairRepository.trouver(idUser);
        System.out.println("::*********************************************::"+c.toString());
        return c;
    }
}
