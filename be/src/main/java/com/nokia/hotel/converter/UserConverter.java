package com.nokia.hotel.converter;

import com.nokia.hotel.config.Constants;
import com.nokia.hotel.entity.UserEntity;
import com.nokia.hotel.service.dto.UserDTO;

import org.springframework.stereotype.Component;

@Component
public class UserConverter {

    public UserDTO ConverterToDTO(UserEntity entity){
        UserDTO dto = new UserDTO();
        dto.setUsername(entity.getUserName());
        dto.setId(entity.getId());
        dto.setFullName(entity.getFullName());
        dto.setPassword(entity.getPassword());
        dto.setPhoneNumber(entity.getPhone());
        dto.setEmail(entity.getEmail());
        dto.setId(entity.getId());
        return dto;
    }

    public UserEntity ConverterToEntity(UserDTO dto){
        UserEntity entity = new UserEntity();
        entity.setUserName(dto.getUsername());
        entity.setFullName(dto.getFullName());
        entity.setPassword(dto.getPassword());
        entity.setPhone(dto.getPhoneNumber());
        entity.setEmail(dto.getEmail());
        entity.setCreatedBy(Constants.SYSTEM);
        entity.setModifiedBy(Constants.SYSTEM);
        return entity;
    }

}
