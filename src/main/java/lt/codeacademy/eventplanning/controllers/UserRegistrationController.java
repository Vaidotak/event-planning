package lt.codeacademy.eventplanning.controllers;


import lt.codeacademy.eventplanning.dto.GetUserRegistrationResponseDTO;
import lt.codeacademy.eventplanning.dto.CreateUserRegistrationRequestDTO;
import lt.codeacademy.eventplanning.entities.UserRegistration;
import lt.codeacademy.eventplanning.services.UserRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ResponseEntity<GetUserRegistrationResponseDTO> getUserById(@PathVariable(name="id") Long id){
        GetUserRegistrationResponseDTO user = this.userRegistrationService.getUsersById(id);

        if(user == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else return ResponseEntity.ok(user);
    }

    @GetMapping("/{id}/birthday")
    public ResponseEntity<String> getUserBirtDayById(@PathVariable(name="id") Long id){
        GetUserRegistrationResponseDTO user = this.userRegistrationService.getUsersById(id);
        if(user == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else return ResponseEntity.ok(user.getBirthDate());
    }

    @PostMapping
    public void addUser(@RequestBody CreateUserRegistrationRequestDTO createUserRegistrationRequestDTO){
        System.out.println(createUserRegistrationRequestDTO.toString());

    }

}
