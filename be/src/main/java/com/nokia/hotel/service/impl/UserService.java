package com.nokia.hotel.service.impl;

import com.nokia.hotel.converter.UserConverter;
import com.nokia.hotel.dto.UserDTO;
import com.nokia.hotel.entity.UserEntity;
import com.nokia.hotel.repository.UserRepository;
import com.nokia.hotel.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements IUserService {

    @Autowired
    UserRepository userRepository;
    UserConverter userConverter = new UserConverter();

    @Override
    public List<UserDTO> getAllNew() {
        List<UserDTO> usersDTO = new ArrayList<>();
        List<UserEntity> usersEntity = new ArrayList<>();
        usersEntity = userRepository.findAll();
        for(UserEntity entity: usersEntity){
            usersDTO.add(userConverter.ConverterToDTO(entity));
        }
        return usersDTO;
    }

    @Override
    public UserDTO saveNew(UserDTO userDTO) {
        return userConverter.ConverterToDTO(userRepository.save(userConverter.ConverterToEntity(userDTO)));
    }
}
