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

    public static void patchUserRegistrationFromCreateUserRegistrationRequestDto(UserRegistration userRegistration,
                                                                                 CreateUserRegistrationRequestDTO requestDTO) {
        if (isNewStringValueEmptyNullOrSameAsOld(requestDTO.getName(), userRegistration.getName())) {
            userRegistration.setName(requestDTO.getName());
        }

        if (isNewStringValueEmptyNullOrSameAsOld(requestDTO.getLastName(), userRegistration.getLastName())) {
            userRegistration.setLastName(requestDTO.getLastName());
        }

        if (isNewStringValueEmptyNullOrSameAsOld(requestDTO.getEMail(), userRegistration.getEMail())) {
            userRegistration.setEMail(requestDTO.getEMail());
        }

        if (isNewStringValueEmptyNullOrSameAsOld(requestDTO.getBirthDate(), userRegistration.getBirthDate())) {
            userRegistration.setBirthDate(requestDTO.getBirthDate());
        }

    }
    private static boolean isNewStringValueEmptyNullOrSameAsOld(String newValue, String oldValue){
        return newValue != null && !newValue.isEmpty() && !newValue.equals(oldValue);
    }
}
