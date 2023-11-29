package com.nokia.hotel.service;

import com.nokia.hotel.dto.UserDTO;

import java.util.List;

public interface IUserService {
    List<UserDTO> getAllNew();
    UserDTO saveNew(UserDTO userDTO);
}
