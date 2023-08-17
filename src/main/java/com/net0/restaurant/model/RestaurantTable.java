package com.net0.restaurant.model;

import com.net0.restaurant.model.enums.Area;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RestaurantTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(requiredMode = Schema.RequiredMode.REQUIRED)
    private Long id;

    @Schema(requiredMode = Schema.RequiredMode.REQUIRED)
    @Column(name = "table_name", nullable = false)
    private String name;

    @Schema(requiredMode = Schema.RequiredMode.REQUIRED)
    @Column(name = "number_of_seats", nullable = false)
    private int seats;

    @Schema(requiredMode = Schema.RequiredMode.REQUIRED)
    @Enumerated(EnumType.STRING)
    @Column(name = "area", nullable = false)
    private Area area;

    @Schema(requiredMode = Schema.RequiredMode.REQUIRED)
    @Column(name = "is_reservable", nullable = false)
    private boolean isReservable;
}
