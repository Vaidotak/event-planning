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
        userRegistrationDTO.setFirstName(userReg.getFirstName());
        userRegistrationDTO.setLastName(userReg.getLastName());
        userRegistrationDTO.setEMail(userReg.getEMail());
        userRegistrationDTO.setBirth(userReg.getBirth());
        }
        return userRegistrationDTO;
    }

    public static UserRegistration convertCreateUserRegistrationRequestDtoToUser(CreateUserRegistrationRequestDTO requestDTO){
        UserRegistration userReg = null;
        if(requestDTO != null){
            userReg = new UserRegistration();
            userReg.setFirstName(requestDTO.getFirstName());
            userReg.setLastName(requestDTO.getLastName());
            userReg.setEMail(requestDTO.getEMail());
            userReg.setBirth(requestDTO.getBirth());
        }
        return userReg;
    }

    public static void patchUserRegistrationFromCreateUserRegistrationRequestDto(UserRegistration userRegistration,
                                                                                 CreateUserRegistrationRequestDTO requestDTO) {
        if (isNewStringValueEmptyNullOrSameAsOld(requestDTO.getFirstName(), userRegistration.getFirstName())) {
            userRegistration.setFirstName(requestDTO.getFirstName());
        }

        if (isNewStringValueEmptyNullOrSameAsOld(requestDTO.getLastName(), userRegistration.getLastName())) {
            userRegistration.setLastName(requestDTO.getLastName());
        }

        if (isNewStringValueEmptyNullOrSameAsOld(requestDTO.getEMail(), userRegistration.getEMail())) {
            userRegistration.setEMail(requestDTO.getEMail());
        }

        if (isNewStringValueEmptyNullOrSameAsOld(requestDTO.getBirth(), userRegistration.getBirth())) {
            userRegistration.setBirth(requestDTO.getBirth());
        }

    }
    private static boolean isNewStringValueEmptyNullOrSameAsOld(String newValue, String oldValue){
        return newValue != null && !newValue.isEmpty() && !newValue.equals(oldValue);
    }
}
