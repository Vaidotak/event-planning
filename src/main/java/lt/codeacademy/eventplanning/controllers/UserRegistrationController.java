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

import static lt.codeacademy.eventplanning.converter.UserRegistrationConverter.convertCreateUserRegistrationRequestDtoToUser;
import static lt.codeacademy.eventplanning.converter.UserRegistrationConverter.convertUserRegistrationToGetUserRegistrationResponseDTO;

@RestController
@RequestMapping("/user-registration")
public class UserRegistrationController {

    @Autowired
    private UserRegistrationService userRegistrationService;

    @GetMapping
    public List<UserRegistration> getAllUsers() {
        return userRegistrationService.getAllUsers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetUserRegistrationResponseDTO> getUserById(@PathVariable(name = "id") Long id) {
        UserRegistration user = this.userRegistrationService.getUsersById(id);

        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else return ResponseEntity.ok(convertUserRegistrationToGetUserRegistrationResponseDTO(user));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> putUserById(@PathVariable(name = "id") Long id,
                                            @RequestBody CreateUserRegistrationRequestDTO createUserRegistrationRequestDTO) {
        UserRegistration user = this.userRegistrationService.getUsersById(id);

        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        UserRegistration newRegistration = convertCreateUserRegistrationRequestDtoToUser(createUserRegistrationRequestDTO);
        newRegistration.setId(user.getId());
        this.userRegistrationService.addSaveUser(newRegistration);


        return ResponseEntity.ok().build();
    }

//    @GetMapping("/{id}/birthday")
//    public ResponseEntity<Void> putUserById(@PathVariable(name="id") Long id){
//        UserRegistration user = this.userRegistrationService.getUsersById(id);
//
//        if(user == null){
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//        else return ResponseEntity.ok(convertUserRegistrationToGetUserRegistrationResponseDTO(user).getBirthDate());
//    }

    @PostMapping
    public void addUser(@RequestBody CreateUserRegistrationRequestDTO createUserRegistrationRequestDTO) {

        UserRegistration userRegistration = convertCreateUserRegistrationRequestDtoToUser(createUserRegistrationRequestDTO);
        this.userRegistrationService.addSaveUser(userRegistration);
        System.out.println(createUserRegistrationRequestDTO.toString());

    }

}
