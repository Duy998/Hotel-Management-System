package com.nokia.hotel.service.impl;

import java.util.List;
import java.util.Optional;

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
		Optional<HotelEntity> optionalHotel = hotelRepository.findById(hotelId);
		if (!optionalHotel.isPresent()) {
			throw new HotelNotFoundException("Hotel not found.");
		}
		return optionalHotel.get();
	}

	@Override
	public HotelEntity updateHotel(HotelDto hotelDto, Long hotelId) {
		HotelEntity updatedHotel = hotelConverter.convert(hotelDto);
		HotelEntity existingHotel = getHotelById(hotelId);
		existingHotel.setAddress(updatedHotel.getAddress());
		existingHotel.setRooms(updatedHotel.getRooms());
		existingHotel.setName(updatedHotel.getName());
		return hotelRepository.save(existingHotel);
	}

	@Override
	public HotelEntity deleteHotel(Long hotelId) {
		HotelEntity hotel = getHotelById(hotelId);
		hotelRepository.deleteById(hotelId);
		return hotel;
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
}
