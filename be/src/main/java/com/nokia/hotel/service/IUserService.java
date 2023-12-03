package com.nokia.hotel.service;

import com.nokia.hotel.dto.UserDTO;
import org.apache.catalina.User;

import java.util.List;

public interface IUserService {
    List<UserDTO> getAllNew();
    UserDTO saveNew(UserDTO userDTO);

    UserDTO RegisterUser(UserDTO userDTO);

    UserDTO Login(UserDTO userDTO);
}
