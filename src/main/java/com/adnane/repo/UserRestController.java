package com.adnane.repo;

import com.adnane.model.AppUser;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.adnane.model.Chair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/utilisateurs"})
@CrossOrigin(origins = "http://localhost:4200")
public class UserRestController {
    
    @Autowired
    private UserRepository userRepository;
    
    Map<String, String> errors;
    
    @RequestMapping(path = "", method = RequestMethod.GET)
    public List<AppUser> getUsers(){
        return userRepository.findAll();
    }

    @RequestMapping(path = "/chercherUser", method = RequestMethod.GET)
    public AppUser findConferenceByUser(@RequestParam(name = "username", defaultValue = "") String username){
        System.out.println("::*********************************************::"+username);
        AppUser c = userRepository.findByUsername(username);
        System.out.println("::*********************************************::"+c.getId());
        return c;
    }
//    
//    @RequestMapping(path = "/findUserByName", method = RequestMethod.GET)
//    public Page<User> findUserByName(@RequestParam(name = "mc", defaultValue = "") String mc, 
//            @RequestParam(name = "page", defaultValue = "0") int page, 
//            @RequestParam(name = "per_page", defaultValue = "5") int size){
//        return userRepository.findByName("%"+mc+"%", PageRequest.of(page, size));
//    }
//    
//    @RequestMapping(path = "/findUserByEmail", method = RequestMethod.GET)
//    public ResponseEntity<Object> findUserByEmail(@RequestParam(name = "mc", defaultValue = "") String mc){
//        User user = userRepository.findByEmail(mc);
//        if(user != null){
//            return new ResponseEntity<>(user, HttpStatus.OK);   
//        }
//        else{
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);   
//        }
//    }
    
//    @RequestMapping(path = "/users", method = RequestMethod.POST)
//    public ResponseEntity<Object> save(@RequestBody User user, BindingResult bindingResult){
//        if(bindingResult.hasErrors()){
//            errors = new HashMap<>();
//            for(FieldError error : bindingResult.getFieldErrors()){
//                errors.put(error.getField(), error.getDefaultMessage());
//            }
//            return new ResponseEntity<>(errors, HttpStatus.NOT_ACCEPTABLE);
//        }
//        User u = userRepository.findByEmail(user.getEmail());
//        if(u != null){
//            return new ResponseEntity<>(HttpStatus.CONFLICT);
//        }
//        return new ResponseEntity<>(userRepository.save(user), HttpStatus.OK);
//    }
    
//    @RequestMapping(value = "/users/profil/{id}", method = RequestMethod.PUT)
//    public ResponseEntity<Object> updateProfil(@PathVariable Long id, @RequestBody User user, BindingResult bindingResult){
//        user.setId(id);
//        if(bindingResult.hasErrors()){
//            errors = new HashMap<>();
//            for(FieldError error : bindingResult.getFieldErrors()){
//                errors.put(error.getField(), error.getDefaultMessage());
//            }
//            return new ResponseEntity<>(errors, HttpStatus.NOT_ACCEPTABLE);
//        }
//        return new ResponseEntity<>(userRepository.save(user), HttpStatus.OK);
//    }
    
//    @RequestMapping(value = "/users/email/{id}", method = RequestMethod.PUT)
//    public ResponseEntity<Object> updateEmail(@PathVariable Long id, @RequestBody UserDto user, BindingResult bindingResult){
//        user.setId(id);
//        User currentUser = userRepository.findById(id).get();
//        if( !user.getPassword().equals(currentUser.getPassword()) ){
//            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
//        }
//        if(bindingResult.hasErrors()){
//            errors = new HashMap<>();
//            for(FieldError error : bindingResult.getFieldErrors()){
//                errors.put(error.getField(), error.getDefaultMessage());
//            }
//            return new ResponseEntity<>(errors, HttpStatus.NOT_ACCEPTABLE);
//        }
//        
//        User u = userRepository.findByEmail(user.getEmail());
//        if(u != null && u.getId() != id){
//            return new ResponseEntity<>(HttpStatus.CONFLICT);
//        }
//        currentUser.setEmail(user.getEmail());
//        return new ResponseEntity<>(userRepository.save(currentUser), HttpStatus.OK);
//    }
//    
//    @RequestMapping(value = "/users/password/{id}", method = RequestMethod.PUT)
//    public ResponseEntity<Object> updatePassword(@PathVariable Long id, @RequestBody UserDto user, BindingResult bindingResult){        
//        user.setId(id);
//        User currentUser = userRepository.findById(id).get();
//        if( !user.getOldPassword().equals(currentUser.getPassword()) ){
//            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
//        }
//        if( !user.getPassword().equals(user.getConfirmPassword()) ){
//            return new ResponseEntity<>(HttpStatus.CONFLICT);
//        }
//        if(bindingResult.hasErrors()){
//            errors = new HashMap<>();
//            for(FieldError error : bindingResult.getFieldErrors()){
//                errors.put(error.getField(), error.getDefaultMessage());
//            }
//            return new ResponseEntity<>(errors, HttpStatus.NOT_ACCEPTABLE);
//        }
//        currentUser.setPassword(user.getPassword());
//        return new ResponseEntity<>(userRepository.save(currentUser), HttpStatus.OK);
//    }
    
}
