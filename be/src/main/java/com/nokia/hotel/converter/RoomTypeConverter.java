package com.nokia.hotel.converter;

import org.springframework.stereotype.Component;

import com.nokia.hotel.entity.RoomTypeEntity;
import com.nokia.hotel.service.dto.RoomTypeDto;

@Component
public class RoomTypeConverter {
    public RoomTypeEntity convert(RoomTypeDto dto) {
        RoomTypeEntity entity = new RoomTypeEntity();
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        entity.setFacilities(dto.getFacilities());
        entity.setImageUrl(dto.getImageUrl());
        entity.setAmount(dto.getAmount());
        entity.setPrice(dto.getPrice());
        return entity;
    }

    public RoomTypeDto convert(RoomTypeEntity entity) {
        RoomTypeDto dto = new RoomTypeDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setDescription(entity.getDescription());
        dto.setFacilities(entity.getFacilities());
        dto.setImageUrl(entity.getImageUrl());
        dto.setAmount(entity.getAmount());
        dto.setPrice(entity.getPrice());
        return dto;
    }
}
