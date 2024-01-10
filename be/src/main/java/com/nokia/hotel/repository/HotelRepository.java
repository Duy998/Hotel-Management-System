package com.nokia.hotel.repository;

import com.nokia.hotel.entity.HotelEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface HotelRepository extends JpaRepository<HotelEntity, Long> {
    HotelEntity findByName(String name);
}
