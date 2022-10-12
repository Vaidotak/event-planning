package lt.codeacademy.eventplanning.services;


import lt.codeacademy.eventplanning.entities.UserRegistration;
import lt.codeacademy.eventplanning.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserRegistrationService {

    private UserRepository userRepository;

    public UserRegistrationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void addUser(UserRegistration userRegistration){
        this.userRepository.save(userRegistration);
    }

}
