package com.nokia.hotel.api;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nokia.hotel.converter.RoomTypeConverter;
import com.nokia.hotel.entity.RoomTypeEntity;
import com.nokia.hotel.payload.response.ApiResponse;
import com.nokia.hotel.payload.response.MessageResponse;
import com.nokia.hotel.service.dto.RoomTypeDto;
import com.nokia.hotel.service.impl.RoomTypeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class RoomTypeController {

    private static final String SUCCESS = "Success";

    @Autowired
    RoomTypeConverter converter;

    @Autowired
    RoomTypeService service;

    @GetMapping("/room-type")
    public ResponseEntity<?> getRoomTypes() {
        List<RoomTypeEntity> list = service.getListRoomType();
		
		List<RoomTypeDto> listDtos = list.stream()
				.map(type -> converter.convert(type))
				.collect(Collectors.toList());
		
		return ResponseEntity.ok().body(new ApiResponse<>(listDtos,
				LocalDate.now(),SUCCESS));
    }

    @PostMapping("/room-type")
    public ResponseEntity<?> addRoomTypes(@RequestBody RoomTypeDto dto) {
        return ResponseEntity.ok().body(new ApiResponse<>(converter.convert(service.addRoomType(dto)),
        LocalDate.now(),"Room type added into DB."));
    }

    @GetMapping("/room-type/{id}")
	public ResponseEntity<?> getRoomTypeById(@PathVariable Long id) {
		boolean isExist = service.existRoomType(id);
		if (!isExist) return ResponseEntity.badRequest().body(new MessageResponse("Error: RoomType is not found!"));
		
		return ResponseEntity.ok().body(new ApiResponse<>(converter.convert(service.getRoomType(id)),
				LocalDate.now(),SUCCESS));
	}

	@PutMapping("/room-type/{id}")
	public ResponseEntity<?> updateRoomType(@RequestBody RoomTypeDto dto, @PathVariable Long id) {
		boolean isExist = service.existRoomType(id);
		if (!isExist) return ResponseEntity.badRequest().body(new MessageResponse("Error: RoomType is not found!"));
		return ResponseEntity.ok().body(new ApiResponse<>(converter.convert(service.updateRoomType(dto, id)),
				LocalDate.now(),"RoomType details updated successfully."));
	}

	@DeleteMapping("/room-type/{id}")
	public ResponseEntity<?> deleteRoomType(@PathVariable Long id) {
		boolean isExist = service.existRoomType(id);
		if (!isExist) return ResponseEntity.badRequest().body(new MessageResponse("Error: RoomType is not found!"));
		boolean isDeleted = service.deleteRoomType(id);
		return ResponseEntity.ok().body(new MessageResponse(isDeleted ? "Deleted successfully." : "Deleted failure"));
	}
    
}
