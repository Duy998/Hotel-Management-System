package com.nokia.hotel.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nokia.hotel.entity.RoomEntity;
import com.nokia.hotel.payload.request.RoomRequest;
import com.nokia.hotel.payload.response.RoomResponse;
import com.nokia.hotel.service.dto.RoomDto;

@Component
public class RoomConterver {
    @Autowired
    HotelConverter hotelConverter;
    @Autowired
    RoomTypeConverter roomTypeConverter;
    public RoomEntity convert(RoomDto roomDto) {
        RoomEntity entity = new RoomEntity();
        entity.setRoomName(roomDto.getRoomName());
        entity.setActived(roomDto.isActived());
        return entity;
    }

    public RoomDto convert(RoomEntity roomEntity) {
        RoomDto roomDto = new RoomDto();
        roomDto.setId(roomEntity.getId());
        roomDto.setRoomName(roomEntity.getRoomName());
        roomDto.setActived(roomEntity.isActived());

        roomDto.setHotel(hotelConverter.convertTHotelResponse(roomEntity.getHotel()));
        roomDto.setRoomType(roomTypeConverter.convert(roomEntity.getRoomType()));
        return roomDto;
    }

    public RoomEntity convert(RoomRequest request) {
        RoomEntity entity = new RoomEntity();
        entity.setRoomName(request.getRoomName());
        entity.setActived(request.isActived());
        return entity;
    }

    public RoomResponse convertToRoomResponse(RoomEntity entity) {
        RoomResponse response = new RoomResponse();
        response.setId(entity.getId());
        response.setName(entity.getRoomName());
        response.setIsActived(entity.isActived());
        response.setHotel(hotelConverter.convertTHotelResponse(entity.getHotel()));
        response.setRoomType(roomTypeConverter.convert(entity.getRoomType()));
        return response;
    }
}
