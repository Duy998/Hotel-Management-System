package com.nokia.hotel.service.dto;

public class RoomDto {
    private long id;

    private String roomName;

    private boolean isActived;

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
