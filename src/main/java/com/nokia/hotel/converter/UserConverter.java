package com.nokia.hotel.converter;

import com.nokia.hotel.dto.UserDTO;
import com.nokia.hotel.entity.UserEntity;

public class UserConverter {

    public UserDTO ConverterToDTO(UserEntity entity){
        UserDTO dto = new UserDTO();
        dto.setUserID(entity.userID);
        dto.setEmail(entity.email);
        dto.setFullName(entity.fullName);
        dto.setPassWord(entity.passWord);
        dto.setPhoneNumber(entity.phoneNumber);
        return dto;
    }

    public UserEntity ConverterToEntity(UserDTO dto){
        UserEntity entity = new UserEntity();
        entity.setUserID(dto.getUserID());
        entity.setEmail(dto.getEmail());
        entity.setFullName(dto.getFullName());
        entity.setPassWord(dto.getPassWord());
        entity.setPhoneNumber(dto.getPhoneNumber());
        return entity;
    }

}
