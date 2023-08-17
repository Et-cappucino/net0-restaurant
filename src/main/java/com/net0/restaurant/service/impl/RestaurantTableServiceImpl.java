package com.net0.restaurant.service.impl;

import com.net0.restaurant.dto.RestaurantTableDto;
import com.net0.restaurant.model.RestaurantTable;
import com.net0.restaurant.repository.RestaurantTableRepository;
import com.net0.restaurant.service.RestaurantTableService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RestaurantTableServiceImpl implements RestaurantTableService {

    private final RestaurantTableRepository restaurantTableRepository;

    @Override
    public List<RestaurantTable> findAllTables() {
        return restaurantTableRepository.findAll();
    }

    @Override
    public RestaurantTable findOne(Long id) {
        return restaurantTableRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public RestaurantTable createTable(RestaurantTableDto tableDto) {
        RestaurantTable table = dtoToTable(tableDto);
        return restaurantTableRepository.save(table);
    }

    @Override
    public RestaurantTable updateTable(Long id, RestaurantTableDto tableDto) {
        RestaurantTable current = restaurantTableRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        RestaurantTable updatedTable = update(current, dtoToTable(tableDto));

        return restaurantTableRepository.save(updatedTable);
    }

    @Override
    public void deleteTable(Long id) {
        restaurantTableRepository.deleteById(id);
    }

    private RestaurantTable dtoToTable(RestaurantTableDto dto) {
        return RestaurantTable.builder()
                .name(dto.getName())
                .seats(dto.getSeats())
                .area(dto.getArea())
                .isReservable(dto.isReservable())
                .build();
    }

    private RestaurantTable update(RestaurantTable current, RestaurantTable updated) {
        current.setName(updated.getName());
        current.setSeats(updated.getSeats());
        current.setArea(updated.getArea());
        current.setReservable(updated.isReservable());
        return current;
    }
}
