package com.adamzurada.bus_routes_service.service;

import com.adamzurada.bus_routes_service.dto.BusStationsConnectionResponseDto;

public interface BusStationsConnectionService {
    /**
     * Checks if there is any direct bus route between requested stations
     *
     * @param departureStationId requested station id of departure by a client
     * @param arrivalStationId   requested station id of arrival by a client
     * @return when exists direct connection than return  {@link BusStationsConnectionResponseDto} with field hasDirectBusRoute set to true
     */
    BusStationsConnectionResponseDto checkIfExistsAnyDirectBusRouteBetweenStations(Integer departureStationId, Integer arrivalStationId);
}
