package com.nokia.hotel.api;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nokia.hotel.converter.HotelConverter;
import com.nokia.hotel.entity.HotelEntity;
import com.nokia.hotel.payload.response.ApiResponse;
import com.nokia.hotel.payload.response.MessageResponse;
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
	public ResponseEntity<ApiResponse<HotelDto>> addHotel(@RequestBody HotelDto hotelDto) {
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
	public ResponseEntity<?> getHotelById(@PathVariable Long hotelId) {
		boolean isExist = hotelService.existHotel(hotelId);
		if (!isExist) return ResponseEntity.badRequest().body(new MessageResponse("Error: Hotel is not found!"));
		
		return ResponseEntity.ok().body(new ApiResponse<>(hotelConverter.convert(hotelService.getHotelById(hotelId)),
				LocalDate.now(),SUCCESS));
	}

	@PutMapping("/hotels/{hotelId}")
	public ResponseEntity<?> updateHotel(@RequestBody HotelDto hotelDto, @PathVariable Long hotelId) {
		boolean isExist = hotelService.existHotel(hotelId);
		if (!isExist) return ResponseEntity.badRequest().body(new MessageResponse("Error: Hotel is not found!"));
		return ResponseEntity.ok().body(new ApiResponse<>(hotelConverter.convert(hotelService.updateHotel(hotelDto, hotelId)),
				LocalDate.now(),"Hotel details updated successfully."));
	}

	@DeleteMapping("/hotels/{hotelId}")
	public ResponseEntity<?> deleteHotel(@PathVariable Long hotelId) {
		boolean isExist = hotelService.existHotel(hotelId);
		if (!isExist) return ResponseEntity.badRequest().body(new MessageResponse("Error: Hotel is not found!"));
		boolean isDeleted = hotelService.deleteHotel(hotelId);
		return ResponseEntity.ok().body(new MessageResponse(isDeleted ? "Deleted successfully." : "Deleted failure"));
	}

	@GetMapping("/hotels/name/{name}")
	public ResponseEntity<ApiResponse<HotelDto>> getHotelByName(@PathVariable String name) {
		return ResponseEntity.ok().body(new ApiResponse<>(hotelConverter.convert(hotelService.getHotelsByName(name)),
				LocalDate.now(),SUCCESS));
	}
}
