package com.adamzurada.bus_routes_service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class BusStationsConnectionRequestDto {

    /**
     * Departure station ID
     */
    @NotNull
    @JsonProperty("dep_sid")
    private Integer departureStationId;

    /**
     * Arrival station ID
     */
    @NotNull
    @JsonProperty("arr_sid")
    private Integer arrivalStationId;
}
