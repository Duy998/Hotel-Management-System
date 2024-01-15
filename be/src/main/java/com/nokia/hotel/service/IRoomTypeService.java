package com.nokia.hotel.service;

import java.util.List;

import com.nokia.hotel.entity.RoomTypeEntity;
import com.nokia.hotel.service.dto.RoomTypeDto;

public interface IRoomTypeService {

    public RoomTypeEntity addRoomType(RoomTypeDto roomTypeDto);

    public RoomTypeEntity getRoomType(Long roomTypeId);

    public List<RoomTypeEntity> getListRoomType();

    public RoomTypeEntity updateRoomType(RoomTypeDto roomTypeDto, Long roomTypeId);

	public boolean deleteRoomType(Long roomTypeId);

	public RoomTypeEntity getRoomTypesByName(String name);

	public boolean existRoomType(Long id);
}
