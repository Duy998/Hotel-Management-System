package com.nokia.hotel.api;

import com.nokia.hotel.dto.UserDTO;
import com.nokia.hotel.entity.UserEntity;
import com.nokia.hotel.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class UserAPI {

    @Autowired
    private IUserService iUserService;

    @GetMapping("/users")
    public List<UserDTO> getUsers(){
        return iUserService.getAllNew();
    }
    @PostMapping("/users")
    public UserDTO postUsers(@RequestBody UserDTO dto){

        return iUserService.saveNew(dto);
    }

}
