package com.nokia.hotel.converter;

import org.springframework.stereotype.Component;

import com.nokia.hotel.entity.HotelEntity;
import com.nokia.hotel.service.dto.HotelDto;
import com.googlecode.jmapper.JMapper;
import com.googlecode.jmapper.api.JMapperAPI;

@Component
public class HotelConverter {
    public HotelEntity convert(HotelDto hotelDto) {
        JMapperAPI api = new JMapperAPI().add(JMapperAPI.mappedClass(HotelEntity.class));
        JMapper<HotelEntity,HotelDto> jMapper = new JMapper<>(HotelEntity.class, HotelDto.class, api);
        return jMapper.getDestination(hotelDto);
    }

    public HotelDto convert(HotelEntity hotelEntity) {
        JMapperAPI api = new JMapperAPI().add(JMapperAPI.mappedClass(HotelDto.class));
        JMapper<HotelDto, HotelEntity> jMapper = new JMapper<>(HotelDto.class, HotelEntity.class, api);
        return jMapper.getDestination(hotelEntity);
    }
}
