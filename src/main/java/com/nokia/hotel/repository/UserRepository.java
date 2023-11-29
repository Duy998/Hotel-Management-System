package com.nokia.hotel.repository;

import com.nokia.hotel.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<UserEntity,String> {
    List<UserEntity> findAll();
    UserEntity save( UserEntity entity);
}
