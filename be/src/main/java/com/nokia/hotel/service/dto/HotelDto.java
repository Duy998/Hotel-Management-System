package com.nokia.hotel.service.dto;

import java.util.List;

public class HotelDto {
    private Long id;	

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    private String name;
	
	private String address;

	private String description;

	private String imageUrl;

	private List<RoomDto> rooms;

    
	public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
	
	public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
	
    public String getImageUrl() {
        return imageUrl;
    }
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

	public List<RoomDto> getRooms() {
        return rooms;
    }
    public void setRooms(List<RoomDto> rooms) {
        this.rooms = rooms;
    }
}
