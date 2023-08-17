package com.net0.restaurant.model;

import com.net0.restaurant.model.enums.Area;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class RestaurantTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "table_name", nullable = false)
    private String name;

    @Column(name = "number_of_seats", nullable = false)
    private int seats;

    @Enumerated(EnumType.STRING)
    @Column(name = "area", nullable = false)
    private Area area;

    @Column(name = "is_reservable", nullable = false)
    private boolean isReservable;
}
