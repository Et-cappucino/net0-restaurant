package com.net0.restaurant.controller;

import com.net0.restaurant.model.RestaurantTable;
import com.net0.restaurant.service.RestaurantTableService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
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

@Tag(name = "Restaurant-Table-Controller")
@RestController
@RequestMapping("/api/tables")
@RequiredArgsConstructor
public class RestaurantTableController {

    private final RestaurantTableService restaurantTableService;

    @Operation(summary = "Get all tables")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "All Tables Found",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = RestaurantTable.class)) })
    })
    @GetMapping
    public ResponseEntity<List<RestaurantTable>> getAllTables() {
        var body = restaurantTableService.findAllTables();
        return ResponseEntity.ok(body);
    }

    @Operation(summary = "Get a table by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Table Found",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = RestaurantTable.class)) }),
            @ApiResponse(responseCode = "404", description = "Table not found", content = @Content) })
    @GetMapping("/{id}")
    public ResponseEntity<RestaurantTable> getTable(@PathVariable Long id) {
        var body = restaurantTableService.findOne(id);
        return ResponseEntity.ok(body);
    }

    @Operation(summary = "Add a new table")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Table Created",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = RestaurantTable.class)) }),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content) })
    @PostMapping
    public ResponseEntity<RestaurantTable> addTable(@RequestBody RestaurantTable table) {
        var body = restaurantTableService.createTable(table);
        return new ResponseEntity<>(body, HttpStatus.CREATED);
    }

    @Operation(summary = "Edit table details by ID with a provided new one")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Table details edited",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = RestaurantTable.class)) }),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content),
            @ApiResponse(responseCode = "404", description = "Table not found", content = @Content)})
    @PutMapping("/{id}")
    public ResponseEntity<RestaurantTable> editTableDetails(@PathVariable Long id,
                                                            @RequestBody RestaurantTable table) {
        var body = restaurantTableService.updateTable(id, table);
        return ResponseEntity.ok(body);
    }

    @Operation(summary = "Delete a table by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Table Deleted"),
            @ApiResponse(responseCode = "404", description = "Table not found", content = @Content) })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTable(@PathVariable Long id) {
        restaurantTableService.deleteTable(id);
        return ResponseEntity.ok().build();
    }
}
