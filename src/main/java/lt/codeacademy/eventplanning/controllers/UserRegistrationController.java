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

import static lt.codeacademy.eventplanning.converter.UserRegistrationConverter.*;

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

    @GetMapping("/{id}/birthday")
    public ResponseEntity<String> getUserBirthById(@PathVariable(name = "id") Long id) {
        UserRegistration user = this.userRegistrationService.getUsersById(id);

        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else return ResponseEntity.ok(convertUserRegistrationToGetUserRegistrationResponseDTO(user).getBirthDate());
    }

    @GetMapping("/{id}/last-name")
    public ResponseEntity<String> getUserLastNameById(@PathVariable(name = "id") Long id) {
        UserRegistration user = this.userRegistrationService.getUsersById(id);

        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else return ResponseEntity.ok(convertUserRegistrationToGetUserRegistrationResponseDTO(user).getLastName());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> putUserById(@PathVariable(name = "id") Long id, @RequestBody CreateUserRegistrationRequestDTO createUserRegistrationRequestDTO) {
        UserRegistration user = this.userRegistrationService.getUsersById(id);

        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        UserRegistration newRegistration = convertCreateUserRegistrationRequestDtoToUser(createUserRegistrationRequestDTO);
        newRegistration.setId(user.getId());
        this.userRegistrationService.addSaveUser(newRegistration);


        return ResponseEntity.ok().build();
    }


    @PostMapping
    public void addUser(@RequestBody CreateUserRegistrationRequestDTO createUserRegistrationRequestDTO) {

        UserRegistration userRegistration = convertCreateUserRegistrationRequestDtoToUser(createUserRegistrationRequestDTO);
        this.userRegistrationService.addSaveUser(userRegistration);
        System.out.println(createUserRegistrationRequestDTO.toString());

    }

    @PatchMapping("/{id}")
    public ResponseEntity<Void> patchUserById(@PathVariable(name = "id") Long id, @RequestBody CreateUserRegistrationRequestDTO createUserRegistrationRequestDTO) {
        UserRegistration user = this.userRegistrationService.getUsersById(id);

        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        patchUserRegistrationFromCreateUserRegistrationRequestDto(user, createUserRegistrationRequestDTO);

        this.userRegistrationService.addSaveUser(user);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUserById(@PathVariable(name = "id") Long id) {
        this.userRegistrationService.deleteUserById(id);
        return ResponseEntity.ok().build();

    }

}
