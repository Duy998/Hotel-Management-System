package com.nokia.hotel.entity;

import java.io.Serializable;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "room")
public class RoomEntity implements Serializable {
     private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "room_name")
    private String roomName;

    @Column(name = "is_actived")
    private boolean isActived;

    @ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "room_type_id", referencedColumnName = "id")
	private RoomTypeEntity roomType;

    @ManyToOne
	@JoinColumn(name = "hotel_id", referencedColumnName = "id")
	private HotelEntity hotel;

    public void setId(Long id) {
        this.id = id;
    }
    public Long getId() {
        return id;
    }
    public String getRoomName() {
        return roomName;
    }
	
    public boolean isActived() {
        return isActived;
    }
    public void setActived(boolean isActived) {
        this.isActived = isActived;
    }
    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

	public RoomTypeEntity getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomTypeEntity roomType) {
        this.roomType = roomType;
    }
    
    public HotelEntity getHotel() {
        return hotel;
    }

    public void setHotel(HotelEntity hotel) {
        this.hotel = hotel;
    }
    
}
