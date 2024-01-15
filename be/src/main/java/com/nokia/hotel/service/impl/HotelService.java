package com.nokia.hotel.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nokia.hotel.converter.HotelConverter;
import com.nokia.hotel.entity.HotelEntity;
import com.nokia.hotel.exception.HotelNotFoundException;
import com.nokia.hotel.repository.HotelRepository;
import com.nokia.hotel.service.IHotelService;
import com.nokia.hotel.service.dto.HotelDto;
@Service
public class HotelService implements IHotelService {
    @Autowired
	private HotelRepository hotelRepository;
	
    @Autowired
    HotelConverter hotelConverter;

	@Override
	public HotelEntity addHotel(HotelDto hotelDto) {
		HotelEntity hotel = hotelConverter.convert(hotelDto);
		HotelEntity newHotel = hotelRepository.save(hotel);
		return newHotel;
	}

	@Override
	public List<HotelEntity> getHotels() {
		return hotelRepository.findAll();
	}

	@Override
	public HotelEntity getHotelById(Long hotelId) {
		return hotelRepository.getReferenceById(hotelId);
	}

	@Override
	public HotelEntity updateHotel(HotelDto hotelDto, Long hotelId) {
		HotelEntity updatedHotel = hotelConverter.convert(hotelDto);
		updatedHotel.setId(hotelId);
		return hotelRepository.save(updatedHotel);
	}

	@Override
	public boolean deleteHotel(Long hotelId) {
		hotelRepository.deleteById(hotelId);
		return !existHotel(hotelId);
	}

	@Override
	public HotelEntity getHotelsByName(String name) {
		HotelEntity hotel = hotelRepository.findByName(name);
		if (hotel != null) {
			return hotel;
			
		}else {
			throw new HotelNotFoundException("Hotel not found.");
		}
		
	}

	@Override
	public boolean existHotel(Long id) {
		return hotelRepository.existsById(id);
	}
}
