package com.nokia.hotel.dataseed;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.nokia.hotel.entity.RoleEntity;
import com.nokia.hotel.entity.UserEntity;
import com.nokia.hotel.repository.RoleRepository;
import com.nokia.hotel.repository.UserRepository;
import com.nokia.hotel.security.AuthoritiesConstants;
@Component
public class UserDataLoader implements CommandLineRunner {
    @Autowired
	UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;

    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public void run(String... args) throws Exception {
        loadUserData();
    }

    private void loadUserData() {
		if (userRepository.count() == 0 && roleRepository.count() != 0) {
            RoleEntity roleAdmin = roleRepository.findOneByName(AuthoritiesConstants.ADMIN);
            RoleEntity roleUser = roleRepository.findOneByName(AuthoritiesConstants.USER);


			UserEntity user1 = new UserEntity();
            String encryptedPassword = passwordEncoder.encode("admin");
            user1.setUserName("admin");
            user1.setPassword(encryptedPassword);
            user1.setFullName("Administrator");
            user1.setEmail("admin@localhost");
            user1.setPhone("19008989");
            user1.setActivated(false);
            user1.setCreatedBy("system");
            user1.setModifiedBy("system");
            user1.setRoles(Set.of(roleAdmin));

			UserEntity user2 = new UserEntity();
            String encryptedPassword2 = passwordEncoder.encode("user");
            user2.setUserName("user");
            user2.setPassword(encryptedPassword2);
            user2.setFullName("User");
            user2.setEmail("user@localhost");
            user2.setPhone("0978657025");
            user2.setActivated(false);
            user2.setCreatedBy("system");
            user2.setModifiedBy("system");
            user2.setRoles(Set.of(roleUser));

			userRepository.save(user1);
			userRepository.save(user2);
		}
		System.out.println(userRepository.count());
	}
}
