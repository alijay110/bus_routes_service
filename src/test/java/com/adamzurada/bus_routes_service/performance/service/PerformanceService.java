package com.adamzurada.bus_routes_service.performance.service;

import com.adamzurada.bus_routes_service.dto.BusStationsConnectionResponseDto;
import com.adamzurada.bus_routes_service.model.BusCoordinates;
import com.adamzurada.bus_routes_service.performance.aspect.LogExecutionTime;
import com.adamzurada.bus_routes_service.service.BusStationsConnectionService;
import com.adamzurada.bus_routes_service.service.DataLoadingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class PerformanceService {

    @Autowired
    private DataLoadingService dataLoadingService;

    @Autowired
    private BusStationsConnectionService busStationsConnectionService;

    @LogExecutionTime
    public void loadBusRoutesCoordinatesFromFile(String absoluteFilePath) {
        dataLoadingService.loadBusRoutesCoordinatesFromFile(absoluteFilePath);
    }

    @LogExecutionTime
    public Set<BusCoordinates> findAllBusCoordinates() {
        return dataLoadingService.findAllBusCoordinates();
    }

    @LogExecutionTime
    public BusStationsConnectionResponseDto checkIfExistsAnyDirectBusRouteBetweenStations(Integer depSid, Integer arrSid) {
        return busStationsConnectionService.checkIfExistsAnyDirectBusRouteBetweenStations(depSid, arrSid);
    }
}
