package lt.codeacademy.eventplanning.controllers;


import lt.codeacademy.eventplanning.entities.UserRegistration;
import lt.codeacademy.eventplanning.services.UserRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user-registration")
public class UserRegistrationController {

    @Autowired
    private UserRegistrationService userRegistrationService;

    @GetMapping
    public List<UserRegistration> getAllUsers(){
        return userRegistrationService.getAllUsers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserRegistration> getUserById(@PathVariable(name="id") Long id){
        Optional<UserRegistration> user = this.userRegistrationService.getUsersById(id);
        if(user.isPresent()){
            return ResponseEntity.ok(user.get());
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}/birthday")
    public ResponseEntity<String> getUserBirtDayById(@PathVariable(name="id") Long id){
        Optional<UserRegistration> user = this.userRegistrationService.getUsersById(id);
        if(user.isPresent()){
            return ResponseEntity.ok(user.get().getBirthDate());
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
