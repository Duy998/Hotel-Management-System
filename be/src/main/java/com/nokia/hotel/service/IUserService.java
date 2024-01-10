package com.nokia.hotel.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.nokia.hotel.service.dto.UserDTO;

import java.util.List;

public interface IUserService {
    List<UserDTO> getAllNew();
    UserDTO saveNew(UserDTO userDTO);

    void registerUser(UserDTO userDTO);
    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;

    UserDTO getUser(Long id);

}
