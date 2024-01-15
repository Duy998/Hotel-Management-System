package com.nokia.hotel.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nokia.hotel.converter.RoomTypeConverter;
import com.nokia.hotel.entity.RoomTypeEntity;
import com.nokia.hotel.repository.RoomTypeRepository;
import com.nokia.hotel.service.IRoomTypeService;
import com.nokia.hotel.service.dto.RoomTypeDto;
@Service
public class RoomTypeService implements IRoomTypeService {

    @Autowired
    RoomTypeConverter converter;

    @Autowired
    RoomTypeRepository repository;

    @Override
    public RoomTypeEntity addRoomType(RoomTypeDto roomTypeDto) {
        RoomTypeEntity entity = converter.convert(roomTypeDto);
        RoomTypeEntity newEntity = repository.save(entity);
        return newEntity;
    }

    @Override
    public RoomTypeEntity getRoomType(Long roomTypeId) {
        return repository.getReferenceById(roomTypeId);
    }

    @Override
    public List<RoomTypeEntity> getListRoomType() {
        return repository.findAll();
    }

    @Override
    public RoomTypeEntity updateRoomType(RoomTypeDto roomTypeDto, Long roomTypeId) {
        RoomTypeEntity entity = converter.convert(roomTypeDto);
        entity.setId(roomTypeId);
        RoomTypeEntity updateEntity = repository.save(entity);
        return updateEntity;
    }

    @Override
    public boolean deleteRoomType(Long roomTypeId) {
        repository.deleteById(roomTypeId);
        return !existRoomType(roomTypeId);
    }

    @Override
    public RoomTypeEntity getRoomTypesByName(String name) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getRoomTypesByName'");
    }

    @Override
    public boolean existRoomType(Long id) {
        return repository.existsById(id);
    }
    
}
