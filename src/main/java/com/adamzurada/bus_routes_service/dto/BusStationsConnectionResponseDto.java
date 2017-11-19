package com.adamzurada.bus_routes_service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BusStationsConnectionResponseDto {

    @JsonProperty("dep_sid")
    private Integer departureStationId;

    @JsonProperty("arr_sid")
    private Integer arrivalStationId;

    @JsonProperty("direct_bus_route")
    private Boolean hasDirectBusRoute;
}
