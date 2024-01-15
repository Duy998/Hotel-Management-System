package com.nokia.hotel.service;

import java.util.List;

import com.nokia.hotel.entity.RoomEntity;
import com.nokia.hotel.payload.request.RoomRequest;

public interface IRoomService {

    public RoomEntity addRoom(RoomRequest roomRequest);

    public List<RoomEntity> getListRoom(Long hotelId, Long roomTypeId);

    public RoomEntity updateRoom(RoomRequest roomRequest, Long roomId);

	public boolean deleteRoom(Long roomId);

	public RoomEntity getRoomByName(String name);

	public boolean existRoom(Long id);

    public RoomEntity getRoom(Long id);
}
