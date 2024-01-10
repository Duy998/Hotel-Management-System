package com.nokia.hotel.service;

import java.util.List;

import com.nokia.hotel.entity.HotelEntity;
import com.nokia.hotel.service.dto.HotelDto;

public interface IHotelService {
    public HotelEntity addHotel(HotelDto hotelDto);

	public List<HotelEntity> getHotels();

	public HotelEntity getHotelById(Long hotelId);

	public HotelEntity updateHotel(HotelDto hotelDto, Long hotelId);

	public HotelEntity deleteHotel(Long hotelId);

	public HotelEntity getHotelsByName(String name);    
}
