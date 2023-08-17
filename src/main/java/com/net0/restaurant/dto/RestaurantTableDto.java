package com.net0.restaurant.dto;

import com.net0.restaurant.model.enums.Area;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RestaurantTableDto {

    @Schema(example = "Emin's Table", requiredMode = Schema.RequiredMode.REQUIRED)
    private String name;

    @Schema(example = "4", requiredMode = Schema.RequiredMode.REQUIRED)
    private int seats;

    @Schema(example = "OUTDOOR", requiredMode = Schema.RequiredMode.REQUIRED)
    private Area area;

    @Schema(example = "true", requiredMode = Schema.RequiredMode.REQUIRED)
    private boolean isReservable;
}
