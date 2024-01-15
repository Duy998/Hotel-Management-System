package com.nokia.hotel.payload.request;

import com.nokia.hotel.service.dto.RoomDto;

public class RoomRequest extends RoomDto {
    private Long hotelId;
    
    private Long roomTypeId;

    public Long getHotelId() {
        return hotelId;
    }

    public void setHotelId(Long hotelId) {
        this.hotelId = hotelId;
    }

    public Long getRoomTypeId() {
        return roomTypeId;
    }

    public void setRoomTypeId(Long roomTypeId) {
        this.roomTypeId = roomTypeId;
    }
}
