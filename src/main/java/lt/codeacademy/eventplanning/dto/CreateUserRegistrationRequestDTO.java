package lt.codeacademy.eventplanning.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class CreateUserRegistrationRequestDTO {

    private String name;
    private String lastName;
    private String eMail;
    private String birthDate;

    @Override
    public String toString() {
        return "SaveUserRegistrationRequestDTO{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", eMail='" + eMail + '\'' +
                ", birthDate='" + birthDate + '\'' +
                '}';
    }
}
