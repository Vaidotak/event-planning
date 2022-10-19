package lt.codeacademy.eventplanning.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class CreateUserRegistrationRequestDTO {

    private String firstName;
    private String lastName;
    private String eMail;
    private String birth;

    @Override
    public String toString() {
        return "SaveUserRegistrationRequestDTO{" +
                "name='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", eMail='" + eMail + '\'' +
                ", birth'" + birth + '\'' +
                '}';
    }
}
