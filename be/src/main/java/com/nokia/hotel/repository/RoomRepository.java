package com.nokia.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nokia.hotel.entity.HotelEntity;
import com.nokia.hotel.entity.RoomEntity;
import com.nokia.hotel.entity.RoomTypeEntity;

import java.util.List;


@Repository
public interface RoomRepository extends JpaRepository<RoomEntity, Long> {
    List<RoomEntity> findByHotel(HotelEntity hotel);
    List<RoomEntity> findByHotelAndRoomType(HotelEntity hotel, RoomTypeEntity roomType);
}
