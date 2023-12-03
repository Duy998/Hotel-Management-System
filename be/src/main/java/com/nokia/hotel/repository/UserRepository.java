package com.nokia.hotel.repository;

import com.nokia.hotel.entity.RoleEntity;
import com.nokia.hotel.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    List<UserEntity> findAll();
    UserEntity save( UserEntity entity);
    UserEntity findOneByUserName(String name);
}
