package com.nokia.hotel.api;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.nokia.hotel.converter.HotelConverter;
import com.nokia.hotel.entity.HotelEntity;
import com.nokia.hotel.payload.response.ApiResponse;
import com.nokia.hotel.service.dto.HotelDto;
import com.nokia.hotel.service.impl.HotelService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class HotelController {
    private static final String SUCCESS = "Success";
    @Autowired
	HotelService hotelService;

	@Autowired
	HotelConverter hotelConverter;

	@PostMapping("/hotels")
    @ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<ApiResponse<HotelDto>> addHotel(HotelDto hotelDto) {
		return ResponseEntity.ok().body(new ApiResponse<>(hotelConverter.convert(hotelService.addHotel(hotelDto)),
        LocalDate.now(),"Hotel added into DB."));
	}

	@GetMapping("/hotels")
	public ResponseEntity<ApiResponse<List<HotelDto>>> getHotels() {
		List<HotelEntity> hotels = hotelService.getHotels();
		
		List<HotelDto> hotelDtos = hotels.stream()
				.map(hotel -> hotelConverter.convert(hotel))
				.collect(Collectors.toList());
		
		return ResponseEntity.ok().body(new ApiResponse<>(hotelDtos,
				LocalDate.now(),SUCCESS));
	}

	@GetMapping("/hotels/{hotelId}")
	public ResponseEntity<ApiResponse<HotelDto>> getHotelById(Long hotelId) {
		return ResponseEntity.ok().body(new ApiResponse<>(hotelConverter.convert(hotelService.getHotelById(hotelId)),
				LocalDate.now(),SUCCESS));
	}

	@PutMapping("/hotels/{hotelId}")
	public ResponseEntity<ApiResponse<HotelDto>> updateHotel(HotelDto hotelDto, Long hotelId) {
		return ResponseEntity.ok().body(new ApiResponse<>(hotelConverter.convert(hotelService.updateHotel(hotelDto, hotelId)),
				LocalDate.now(),"Hotel details updated successfully."));
	}

	@DeleteMapping("/hotels/{hotelId}")
	public ResponseEntity<ApiResponse<HotelDto>> deleteHotel(Long hotelId) {
		return ResponseEntity.ok().body(new ApiResponse<>(hotelConverter.convert(hotelService.deleteHotel(hotelId)),
				LocalDate.now(),"Hotel deleted successfully."));
	}

	@GetMapping("/hotels/name/{name}")
	public ResponseEntity<ApiResponse<HotelDto>> getHotelByName(String name) {
		return ResponseEntity.ok().body(new ApiResponse<>(hotelConverter.convert(hotelService.getHotelsByName(name)),
				LocalDate.now(),SUCCESS));
	}
}
