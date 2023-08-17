package com.net0.restaurant.controller;

import com.net0.restaurant.model.RestaurantTable;
import com.net0.restaurant.service.RestaurantTableService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/tables")
@RequiredArgsConstructor
public class RestaurantTableController {

    private final RestaurantTableService restaurantTableService;

    @GetMapping
    public ResponseEntity<List<RestaurantTable>> getAllTables() {
        var body = restaurantTableService.findAllTables();
        return ResponseEntity.ok(body);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RestaurantTable> getTable(@PathVariable Long id) {
        var body = restaurantTableService.findOne(id);
        return ResponseEntity.ok(body);
    }

    @PostMapping
    public ResponseEntity<RestaurantTable> addTable(@RequestBody RestaurantTable table) {
        var body = restaurantTableService.createTable(table);
        return new ResponseEntity<>(body, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RestaurantTable> editTableDetails(@PathVariable Long id,
                                                            @RequestBody RestaurantTable table) {
        var body = restaurantTableService.updateTable(id, table);
        return ResponseEntity.ok(body);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTable(@PathVariable Long id) {
        restaurantTableService.deleteTable(id);
        return ResponseEntity.ok().build();
    }
}
