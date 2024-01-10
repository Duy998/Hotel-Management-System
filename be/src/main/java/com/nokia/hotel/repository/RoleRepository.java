package com.nokia.hotel.repository;

import com.nokia.hotel.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, Long> {
    RoleEntity findOneByName(String name);
}
