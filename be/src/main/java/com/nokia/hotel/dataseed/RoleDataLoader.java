package com.nokia.hotel.dataseed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nokia.hotel.entity.RoleEntity;
import com.nokia.hotel.repository.RoleRepository;
import com.nokia.hotel.security.AuthoritiesConstants;
@Component
public class RoleDataLoader implements CommandLineRunner {
    @Autowired
    RoleRepository roleRepository;

    @Override
    public void run(String... args) throws Exception {
        loadRoleData();
    }

    private void loadRoleData() {
        if (roleRepository.count() == 0) {
            RoleEntity role1 = new RoleEntity();  role1.setName(AuthoritiesConstants.ADMIN);
            RoleEntity role2 = new RoleEntity(); role2.setName(AuthoritiesConstants.USER);
            roleRepository.save(role1);
            roleRepository.save(role2);
        }
        System.out.println(roleRepository.count());
    }
    
}
