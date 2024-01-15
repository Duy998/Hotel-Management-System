package com.nokia.hotel.service.dto;

import com.nokia.hotel.payload.response.HotelResponse;

public class RoomDto {
    private long id;

    private String roomName;

    private boolean isActived;
    public HotelResponse getHotel() {
        return hotel;
    }

    public void setHotel(HotelResponse hotel) {
        this.hotel = hotel;
    }

    private HotelResponse hotel;
    private RoomTypeDto roomType;

    public RoomTypeDto getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomTypeDto roomType) {
        this.roomType = roomType;
    }

    public boolean isActived() {
        return isActived;
    }

    public void setActived(boolean isActived) {
        this.isActived = isActived;
    }

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

}
