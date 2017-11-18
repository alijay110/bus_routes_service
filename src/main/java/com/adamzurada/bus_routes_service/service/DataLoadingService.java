package com.adamzurada.bus_routes_service.service;

import com.adamzurada.bus_routes_service.model.BusCoordinates;

import java.util.Set;

public interface DataLoadingService {

    /**
     * Finds all bus coordinates
     *
     * @return set of bus coordinates
     */
    Set<BusCoordinates> findAllBusCoordinates();

    /**
     * Loads file and maps entries to {@code HashSet<BusCoordinates>}
     *
     * @param absoluteFilePath absolute location of file with the bus routes data
     */
    void loadBusRoutesCoordinatesFromFile(String absoluteFilePath);
}
