package com.nokia.hotel.api;

import com.nokia.hotel.dto.UserDTO;
import com.nokia.hotel.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/user")
public class UserAPI {

    @Autowired
    private IUserService iUserService;

    @GetMapping
    public List<UserDTO> getUsers(){
        return iUserService.getAllNew();
    }
    @PostMapping
    public UserDTO postUsers(@RequestBody UserDTO dto){
        return iUserService.saveNew(dto);
    }

    @PostMapping("/register")
    public UserDTO Register(@RequestBody UserDTO dto){
        return iUserService.RegisterUser(dto);
    }

    @PostMapping("/login")
    public UserDTO Login(@RequestBody UserDTO dto){
        return iUserService.Login(dto);
    }
    @GetMapping("/{id}")
    public UserDTO getUserById(@PathVariable Long id) {
        return iUserService.getUser(id);
    }

    @PutMapping("/{id}")
    public UserDTO updateUserById(@PathVariable Long id, @RequestBody UserDTO updatedUser){
        System.out.print(updatedUser);
        System.out.print(id);
        return null;
    }

    @DeleteMapping("/{id}")
    public UserDTO deleteUserById(@PathVariable Long id){
        System.out.print(id);
        System.out.print(id);

        return null;
    }
}
