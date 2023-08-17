package com.net0.restaurant.service;

import com.net0.restaurant.model.RestaurantTable;

import java.util.List;

public interface RestaurantTableService {

    List<RestaurantTable> findAllTables();

    RestaurantTable findOne(Long id);

    RestaurantTable createTable(RestaurantTable table);

    RestaurantTable updateTable(Long id, RestaurantTable table);

    void deleteTable(Long id);
}
