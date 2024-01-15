package com.nokia.hotel.payload.response;

import com.nokia.hotel.service.dto.RoomTypeDto;

public class RoomResponse {
    Long id;
    String name;
    boolean isActived;
    HotelResponse hotel;
    RoomTypeDto roomType;
    public void setId(Long id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setIsActived(boolean isActived) {
        this.isActived = isActived;
    }
    public void setHotel(HotelResponse hotel) {
        this.hotel = hotel;
    }
    public void setRoomType(RoomTypeDto roomType) {
        this.roomType = roomType;
    }
}
