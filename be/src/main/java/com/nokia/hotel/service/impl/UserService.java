package com.nokia.hotel.service.impl;

import com.nokia.hotel.converter.UserConverter;
import com.nokia.hotel.entity.HotelEntity;
import com.nokia.hotel.entity.RoleEntity;
import com.nokia.hotel.entity.UserEntity;
import com.nokia.hotel.repository.RoleRepository;
import com.nokia.hotel.repository.UserRepository;
import com.nokia.hotel.security.AuthoritiesConstants;
import com.nokia.hotel.service.IUserService;
import com.nokia.hotel.service.dto.UserDTO;
import com.nokia.hotel.service.dto.UserDetailsImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class UserService implements IUserService, UserDetailsService  {

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
        for (UserEntity entitys : usersEntity) {
            UserDTO user = new UserDTO();
            user = userConverter.ConverterToDTO(entitys);
            for (RoleEntity entity: entitys.getRoles()) {
                user.setRoleCode(entity.getName());
            };
            usersDTO.add(user);
        }
        return usersDTO;
    }

    @Override
    public UserDTO saveNew(UserDTO userDTO) {
        return userConverter.ConverterToDTO(userRepository.save(userConverter.ConverterToEntity(userDTO)));
    }

    @Override
    public void registerUser(UserDTO userDTO) {
        UserEntity userEntity = userConverter.ConverterToEntity(userDTO);
        RoleEntity role = roleRepository.findOneByName(AuthoritiesConstants.USER);
        userEntity.setRoles(Set.of(role));
        userEntity.setActivated(false);

        userRepository.save(userEntity);
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));

        return UserDetailsImpl.build(user);
    }

    @Override
    public UserDTO getUser(Long id) {
        UserEntity userEntity = userRepository.findOneById(id);
        UserDTO userDTO = userConverter.ConverterToDTO(userEntity);
        for (RoleEntity entity: userEntity.getRoles()) {
            userDTO.setRoleCode(entity.getName());
        }
        return userDTO;
    }

    @Override
    public UserDTO deleteUser(Long id) {
        UserDTO user = getUser(id);
        userRepository.deleteById(id);
        return user;
    }

    @Override
    public UserDTO updateUser(UserDTO userDTO, Long id) {
        UserEntity userEntity = userConverter.ConverterToEntity(userDTO);
        UserEntity existingUser = userRepository.findOneById(id);
        existingUser.setUserName(userEntity.getUserName());
        existingUser.setEmail(userEntity.getEmail());
        existingUser.setPassword(userEntity.getPassword());
        existingUser.setFullName(userEntity.getFullName());
        existingUser.setPhone(userEntity.getPhone());
        RoleEntity role = roleRepository.findOneByName(userDTO.getRoleCode());
//        existingUser.setRoles(Set.of(role));
        existingUser.setActivated(false);
        userRepository.save(existingUser);
        return getUser(id);
    }
}
