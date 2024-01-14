package com.nokia.hotel.api;

import com.nokia.hotel.payload.response.MessageResponse;
import com.nokia.hotel.repository.UserRepository;
import com.nokia.hotel.service.IUserService;
import com.nokia.hotel.service.dto.UserDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class UserAPI {

    @Autowired
    UserRepository userRepository;

    @Autowired
    private IUserService iUserService;

    @Autowired
    PasswordEncoder encoder;

    @GetMapping("/user")
    public List<UserDTO> getUsers(){
        return iUserService.getAllNew();
    }
    @PostMapping("/user")
    public ResponseEntity<?> addUser(@RequestBody UserDTO dto){
        if (userRepository.existsByUsername(dto.getUsername())) {
            return ResponseEntity.badRequest().body(new MessageResponse("Error: Username is already taken!"));
        }

        if (userRepository.existsByEmail(dto.getEmail())) {
            return ResponseEntity.badRequest().body(new MessageResponse("Error: Email is already in use!"));
        }
        if (userRepository.existsByPhone(dto.getPhoneNumber())) {
            return ResponseEntity.badRequest().body(new MessageResponse("Error: Phone number is already in use!"));
        }
        dto.setPassword(encoder.encode(dto.getPassword()));
        iUserService.registerUser(dto);
        return ResponseEntity.ok(new MessageResponse("Add user successfully!"));
    }

    @GetMapping("/user/{id}")
    public UserDTO getUserById(@PathVariable Long id) {
        return iUserService.getUser(id);
    }

    @PutMapping("/user/{id}")
    public UserDTO updateUserById(@PathVariable Long id, @RequestBody UserDTO updatedUser){
        System.out.print(updatedUser);
        System.out.print(id);
        return iUserService.updateUser(updatedUser, id);
    }

    @DeleteMapping("/user/{id}")
    public UserDTO deleteUserById(@PathVariable Long id){
        return iUserService.deleteUser(id);
    }
}
