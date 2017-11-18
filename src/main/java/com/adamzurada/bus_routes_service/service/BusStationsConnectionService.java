package com.adamzurada.bus_routes_service.service;

import com.adamzurada.bus_routes_service.dto.BusStationsConnectionRequestDto;
import com.adamzurada.bus_routes_service.dto.BusStationsConnectionResponseDto;

public interface BusStationsConnectionService {
    /**
     * Checks if there is any direct bus route between requested stations
     *
     * @param busStationsConnectionRequestDto requested dto station id of departure and arrival by a client
     * @return when exists direct connection than return  {@link BusStationsConnectionResponseDto} with field hasDirectBusRoute set to true
     */
    BusStationsConnectionResponseDto checkIfExistsAnyDirectBusRouteBetweenStations(BusStationsConnectionRequestDto busStationsConnectionRequestDto);
}
