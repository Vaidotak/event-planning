package lt.codeacademy.eventplanning.repositories;

import lt.codeacademy.eventplanning.entities.UserRegistration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserRegistration, Long> {
}
