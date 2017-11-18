package com.adamzurada.bus_routes_service.dto;

import lombok.Data;

@Data
public class BusRouteDto {

    /**
     * ID of a route
     */
    private int routeId;

    /**
     * Departure position within a route for found departure stationId
     */
    private int departurePosition;

    /**
     * Arrival position within a route for found arrival stationId
     */
    private int arrivalPosition;
}
