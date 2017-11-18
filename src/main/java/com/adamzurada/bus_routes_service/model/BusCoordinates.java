package com.adamzurada.bus_routes_service.model;

import lombok.Data;

@Data
public class BusCoordinates {

    /**
     * ID of a route
     */
    private int routeId;

    /**
     * ID of a station
     */
    private int stationId;

    /**
     * Position within route
     * values from 0 to n where n is quantity of stations within a route
     */
    private int position;
}
