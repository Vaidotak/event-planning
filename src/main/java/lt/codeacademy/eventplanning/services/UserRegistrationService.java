package lt.codeacademy.eventplanning.services;


import lt.codeacademy.eventplanning.entities.UserRegistration;
import lt.codeacademy.eventplanning.repositories.UserRepository;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class UserRegistrationService {

    private UserRepository userRepository;

    public UserRegistrationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserRegistration> getAllUsers() {
        return this.userRepository.findAll();
    }

    public UserRegistration getUsersById(Long id) {

        Optional<UserRegistration> user = this.userRepository.findById(id);
        if (user.isPresent()) {

            return user.get();
        } else {
            return null;
        }
    }


    public void addSaveUser(UserRegistration userRegistration) {
        this.userRepository.save(userRegistration);
    }

    public void deleteUserById(Long id) {
        this.userRepository.deleteById(id);
    }

}
