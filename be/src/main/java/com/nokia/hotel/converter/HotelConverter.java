package com.nokia.hotel.converter;

import org.springframework.stereotype.Component;

import com.nokia.hotel.entity.HotelEntity;
import com.nokia.hotel.payload.response.HotelResponse;
import com.nokia.hotel.service.dto.HotelDto;

@Component
public class HotelConverter {
    public HotelEntity convert(HotelDto hotelDto) {
       HotelEntity entity = new HotelEntity();
       entity.setAddress(hotelDto.getAddress());
       entity.setName(hotelDto.getName());
       entity.setDescription(hotelDto.getDescription());
       entity.setImageUrl(hotelDto.getImageUrl());
       return entity;       
    }

    public HotelDto convert(HotelEntity hotelEntity) {
        HotelDto hotelDto = new HotelDto();
        hotelDto.setId(hotelEntity.getId());
        hotelDto.setAddress(hotelEntity.getAddress());
        hotelDto.setName(hotelEntity.getName());
        hotelDto.setDescription(hotelEntity.getDescription());
        hotelDto.setImageUrl(hotelEntity.getImageUrl());
        return hotelDto;
    }

    public HotelResponse convertTHotelResponse(HotelEntity hotelEntity) {
        HotelResponse response = new HotelResponse();
        response.setId(hotelEntity.getId());
        response.setName(hotelEntity.getName());
        return response;
    }
}
