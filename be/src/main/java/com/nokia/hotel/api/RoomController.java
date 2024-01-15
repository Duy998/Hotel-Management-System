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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nokia.hotel.converter.RoomConterver;
import com.nokia.hotel.entity.RoomEntity;
import com.nokia.hotel.payload.request.RoomRequest;
import com.nokia.hotel.payload.response.ApiResponse;
import com.nokia.hotel.payload.response.MessageResponse;
import com.nokia.hotel.payload.response.RoomResponse;
import com.nokia.hotel.repository.HotelRepository;
import com.nokia.hotel.repository.RoomTypeRepository;
import com.nokia.hotel.service.dto.RoomDto;
import com.nokia.hotel.service.impl.RoomService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class RoomController {
    private static final String SUCCESS = "Success";

    @Autowired
    RoomConterver converter;

    @Autowired
    RoomService service;
    @Autowired
    HotelRepository hotelRepository;

    @Autowired
    RoomTypeRepository roomTypeRepository;

    @GetMapping("/{hotelId}/room")
    public ResponseEntity<?> getRooms(@PathVariable Long hotelId, @RequestParam(name = "room-type-id", required = false) Long roomTypeId) {
        boolean isExistHotel = hotelRepository.existsById(hotelId);
		if (!isExistHotel) return ResponseEntity.badRequest().body(new MessageResponse("Error: Hotel is not found!"));
        if (roomTypeId != null) {
            boolean isExistType = roomTypeRepository.existsById(roomTypeId);
		    if (!isExistType) return ResponseEntity.badRequest().body(new MessageResponse("Error: Room type is not found!"));
        }       
        
        List<RoomEntity> list = service.getListRoom(hotelId, roomTypeId);
		
		List<RoomDto> listDtos = list.stream()
				.map(type -> converter.convert(type))
				.collect(Collectors.toList());
		
		return ResponseEntity.ok().body(new ApiResponse<>(listDtos,
				LocalDate.now(),SUCCESS));
    }

    @PostMapping("/room")
    public ResponseEntity<?> addRooms(@RequestBody RoomRequest request) {
		boolean isExistHotel = hotelRepository.existsById(request.getHotelId());
		if (!isExistHotel) return ResponseEntity.badRequest().body(new MessageResponse("Error: Hotel is not found!"));
        
            boolean isExistType = roomTypeRepository.existsById(request.getRoomTypeId());
		    if (!isExistType) return ResponseEntity.badRequest().body(new MessageResponse("Error: Room type is not found!"));
        
        return ResponseEntity.ok().body(new ApiResponse<>(converter.convert(service.addRoom(request)),
        LocalDate.now(),"Room added into DB."));
    }

    @GetMapping("/room/{id}")
	public ResponseEntity<?> getRoomById(@PathVariable Long id) {
		boolean isExist = service.existRoom(id);
		if (!isExist) return ResponseEntity.badRequest().body(new MessageResponse("Error: Room is not found!"));
		
		return ResponseEntity.ok().body(new ApiResponse<>(converter.convert(service.getRoom(id)),
				LocalDate.now(),SUCCESS));
	}

	@PutMapping("/room/{id}")
	public ResponseEntity<?> updateRoom(@RequestBody RoomRequest roomRequest, @PathVariable Long id) {
		boolean isExist = service.existRoom(id);
		if (!isExist) return ResponseEntity.badRequest().body(new MessageResponse("Error: Room is not found!"));
		return ResponseEntity.ok().body(new ApiResponse<>(converter.convert(service.updateRoom(roomRequest, id)),
				LocalDate.now(),"Room details updated successfully."));
	}

	@DeleteMapping("/room/{id}")
	public ResponseEntity<?> deleteRoom(@PathVariable Long id) {
		boolean isExist = service.existRoom(id);
		if (!isExist) return ResponseEntity.badRequest().body(new MessageResponse("Error: Room is not found!"));
		boolean isDeleted = service.deleteRoom(id);
		return ResponseEntity.ok().body(new MessageResponse(isDeleted ? "Deleted successfully." : "Deleted failure"));
	}
}
