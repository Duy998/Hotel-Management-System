package com.nokia.hotel.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nokia.hotel.converter.RoomConterver;
import com.nokia.hotel.entity.HotelEntity;
import com.nokia.hotel.entity.RoomEntity;
import com.nokia.hotel.entity.RoomTypeEntity;
import com.nokia.hotel.payload.request.RoomRequest;
import com.nokia.hotel.repository.HotelRepository;
import com.nokia.hotel.repository.RoomRepository;
import com.nokia.hotel.repository.RoomTypeRepository;
import com.nokia.hotel.service.IRoomService;

@Service
public class RoomService implements IRoomService {
    @Autowired
    RoomConterver converter;

    @Autowired
    RoomRepository repository;

    @Autowired
    HotelRepository hotelRepository;

    @Autowired
    RoomTypeRepository roomTypeRepository;

    @Override
    public RoomEntity addRoom(RoomRequest roomRequest) {
        HotelEntity hotel = hotelRepository.getReferenceById(roomRequest.getHotelId());
        RoomTypeEntity roomType = roomTypeRepository.getReferenceById(roomRequest.getRoomTypeId());
        RoomEntity entity = converter.convert(roomRequest);
        entity.setHotel(hotel);
        entity.setRoomType(roomType);
        RoomEntity newEntity = repository.save(entity);
        return newEntity;
    }

    @Override
    public List<RoomEntity> getListRoom(Long hotelId, Long roomTypeId) {
        HotelEntity hotel = hotelRepository.getReferenceById(hotelId);        
        if (roomTypeId != null) {
            RoomTypeEntity roomType = roomTypeRepository.getReferenceById(roomTypeId);
            return repository.findByHotelAndRoomType(hotel, roomType);
        }       
        return repository.findByHotel(hotel);
    }

    @Override
    public RoomEntity updateRoom(RoomRequest roomRequest, Long roomId) {
        HotelEntity hotel = hotelRepository.getReferenceById(roomRequest.getHotelId());
        RoomTypeEntity roomType = roomTypeRepository.getReferenceById(roomRequest.getRoomTypeId());
        RoomEntity entity = converter.convert(roomRequest);
        entity.setId(roomId);
        entity.setHotel(hotel);
        entity.setRoomType(roomType);
        RoomEntity updateEntity = repository.save(entity);
        return updateEntity;
    }

    @Override
    public boolean deleteRoom(Long roomId) {
        repository.deleteById(roomId);
        return !existRoom(roomId);
    }

    @Override
    public RoomEntity getRoomByName(String name) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getRoomByName'");
    }

    @Override
    public boolean existRoom(Long id) {
        return repository.existsById(id);
    }

    @Override
    public RoomEntity getRoom(Long id) {
        return repository.getReferenceById(id);
    }
    
}
