package lt.codeacademy.eventplanning.converter;

import lt.codeacademy.eventplanning.dto.CreateUserRegistrationRequestDTO;
import lt.codeacademy.eventplanning.dto.GetUserRegistrationResponseDTO;
import lt.codeacademy.eventplanning.entities.UserRegistration;

public class UserRegistrationConverter {

    public static GetUserRegistrationResponseDTO convertUserRegistrationToGetUserRegistrationResponseDTO(UserRegistration userReg){
        GetUserRegistrationResponseDTO userRegistrationDTO = null;
        if(userReg != null){

        userRegistrationDTO  = new GetUserRegistrationResponseDTO();
        userRegistrationDTO.setId(userReg.getId());
        userRegistrationDTO.setName(userReg.getName());
        userRegistrationDTO.setLastName(userReg.getLastName());
        userRegistrationDTO.setEMail(userReg.getEMail());
        userRegistrationDTO.setBirthDate(userReg.getBirthDate());
        }
        return userRegistrationDTO;
    }

    public static UserRegistration convertCreateUserRegistrationRequestDtoToUser(CreateUserRegistrationRequestDTO requestDTO){
        UserRegistration userReg = null;
        if(requestDTO != null){
            userReg = new UserRegistration();
            userReg.setName(requestDTO.getName());
            userReg.setLastName(requestDTO.getLastName());
            userReg.setEMail(requestDTO.getEMail());
            userReg.setBirthDate(requestDTO.getBirthDate());
        }
        return userReg;
    }
}
