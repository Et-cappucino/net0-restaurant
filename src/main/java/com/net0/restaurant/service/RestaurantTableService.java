package com.net0.restaurant.service;

import com.net0.restaurant.dto.RestaurantTableDto;
import com.net0.restaurant.model.RestaurantTable;

import java.util.List;

public interface RestaurantTableService {

    List<RestaurantTable> findAllTables();

    RestaurantTable findOne(Long id);

    RestaurantTable createTable(RestaurantTableDto tableDto);

    RestaurantTable updateTable(Long id, RestaurantTableDto tableDto);

    void deleteTable(Long id);
}
