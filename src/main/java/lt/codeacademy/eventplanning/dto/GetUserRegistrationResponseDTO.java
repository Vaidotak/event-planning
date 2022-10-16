package lt.codeacademy.eventplanning.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class GetUserRegistrationResponseDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private String eMail;
    private String birth;
}
