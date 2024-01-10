package com.nokia.hotel.entity;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "hotel")
public class HotelEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;	

    @Column(name = "name")	
	private String name;
	
	@Column(name = "address")	
	private String address;

    @Column(name = "description")	
	private String description;

    @Column(name = "image_url")	
	private String imageUrl;

    @OneToMany(cascade=CascadeType.ALL, mappedBy = "hotel")	
	private List<RoomEntity> rooms;

    public Long getId() {
        return id;
    }
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

	public List<RoomEntity> getRooms() {
        return rooms;
    }
    public void setRooms(List<RoomEntity> rooms) {
        this.rooms = rooms;
    }

}
