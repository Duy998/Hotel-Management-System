package com.nokia.hotel.service.impl;

import com.nokia.hotel.converter.UserConverter;
import com.nokia.hotel.dto.UserDTO;
import com.nokia.hotel.entity.RoleEntity;
import com.nokia.hotel.entity.UserEntity;
import com.nokia.hotel.repository.RoleRepository;
import com.nokia.hotel.repository.UserRepository;
import com.nokia.hotel.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class UserService implements IUserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    UserConverter userConverter;



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

    @Override
    public UserDTO RegisterUser(UserDTO userDTO) {
        UserDTO result = new UserDTO();
        UserEntity userEntity = userConverter.ConverterToEntity(userDTO);
        RoleEntity role = roleRepository.findOneByCode("USER");
        userEntity.setRoles(Stream.of(role).collect(Collectors.toList()));
        UserEntity getByUsername = userRepository.findOneByUserName(userEntity.getUserName());
        if(getByUsername != null){
            result.setMessage("User da ton tai");
            return result;
        }
        result = userConverter.ConverterToDTO(userRepository.save(userEntity));
        return result;
    }

    @Override
    public UserDTO Login(UserDTO userDTO) {
        UserEntity userEntity = userConverter.ConverterToEntity(userDTO);
//        UserEntity user = userRepository.
//        #RoleEntity role = roleRepository.findOneByCode(userDTO.getRoleCode());
        UserEntity user = userRepository.findByUserNameAndPassword(userEntity.getUserName(),userEntity.getPassword());
        UserDTO userDTO1 = new UserDTO();
        if(user == null){
            userDTO1.setMessage("user or password khong dung");
            return  userDTO1;
        }
        userDTO1 = userConverter.ConverterToDTO(user);
        for ( RoleEntity role : user.getRoles()) {
            userDTO1.setRoleCode(role.getCode());
        }
        return userDTO1;
    }
}
