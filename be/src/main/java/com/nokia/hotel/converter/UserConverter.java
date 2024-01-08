package com.nokia.hotel.converter;

import com.nokia.hotel.dto.UserDTO;
import com.nokia.hotel.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {

    public UserDTO ConverterToDTO(UserEntity entity){
        UserDTO dto = new UserDTO();
        dto.setId(entity.getId());
        dto.setUserName(entity.getUserName());
        dto.setFullName(entity.getFullName());
        dto.setPassword(entity.getPassword());
        dto.setPhone(entity.getPhone());
        dto.setEmail(entity.getEmail());
        return dto;
    }

    public UserEntity ConverterToEntity(UserDTO dto){
        UserEntity entity = new UserEntity();
        entity.setUserName(dto.getUserName());
        entity.setFullName(dto.getFullName());
        entity.setPassword(dto.getPassword());
        entity.setPhone(dto.getPhone());
        entity.setEmail(dto.getEmail());
        return entity;
    }

}
