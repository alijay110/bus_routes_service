package com.adamzurada.bus_routes_service.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BusCoordinates {

    /**
     * ID of a route
     */
    private int routeId;

    /**
     * ID of a station
     */
    private int stationId;

}
