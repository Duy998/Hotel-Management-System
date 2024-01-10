package com.nokia.hotel.repository;

import com.nokia.hotel.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    List<UserEntity> findAll();
    Optional<UserEntity> findByUsername(String username);
    boolean existsByUsername(String username);

    boolean existsByEmail(String email);
    boolean existsByPhone(String phone);
    UserEntity save( UserEntity entity);

    UserEntity findOneById(Long id);
}
