package lt.codeacademy.eventplanning.services;


import lt.codeacademy.eventplanning.dto.GetUserRegistrationResponseDTO;
import lt.codeacademy.eventplanning.entities.UserRegistration;
import lt.codeacademy.eventplanning.repositories.UserRepository;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

import static lt.codeacademy.eventplanning.converter.UserRegistrationConverter.convertUserRegistrationToGetUserRegistrationResponseDTO;

@Service
public class UserRegistrationService {

    private UserRepository userRepository;

    public UserRegistrationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserRegistration> getAllUsers() {
        return this.userRepository.findAll();
    }

    public GetUserRegistrationResponseDTO getUsersById(Long id) {

        Optional<UserRegistration> user = this.userRepository.findById(id);
        if (user.isPresent()) {

            return convertUserRegistrationToGetUserRegistrationResponseDTO(user.get());
        } else {
            return null;
        }
    }

    public void addUser(UserRegistration userRegistration) {
        this.userRepository.save(userRegistration);
    }

}
