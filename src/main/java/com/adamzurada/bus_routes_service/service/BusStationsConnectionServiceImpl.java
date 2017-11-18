package com.adamzurada.bus_routes_service.service;

import com.adamzurada.bus_routes_service.dto.BusStationsConnectionResponseDto;
import com.adamzurada.bus_routes_service.model.BusCoordinates;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Slf4j
@Service
public class BusStationsConnectionServiceImpl implements BusStationsConnectionService {

    private final DataLoadingService dataLoadingService;

    @Autowired
    public BusStationsConnectionServiceImpl(DataLoadingService dataLoadingService) {
        this.dataLoadingService = dataLoadingService;
    }

    @Override
    public BusStationsConnectionResponseDto checkIfExistsAnyDirectBusRouteBetweenStations(Integer departureStationId, Integer arrivalStationId) {
        Map<Integer, Long> routesMap = findAllRoutesHavingRequestedStations(departureStationId, arrivalStationId);
        boolean hasDirectBusRoute = isAnyDirectBusRouteBetweenStations(routesMap);
        return BusStationsConnectionResponseDto.builder()
                .departureStationId(departureStationId)
                .arrivalStationId(arrivalStationId)
                .hasDirectBusRoute(hasDirectBusRoute)
                .build();
    }

    /**
     * Finds all routes having departure or arrival station ids
     *
     * @param departureStationId departure station id to look for
     * @param arrivalStationId   arrival station id to look for
     * @return Map where key is routeId and value is quantity of found station ids for particular route
     */
    private Map<Integer, Long> findAllRoutesHavingRequestedStations(Integer departureStationId, Integer arrivalStationId) {
        return dataLoadingService.findAllBusCoordinates()
                .stream()
                .filter(filterByDepartureAndArrivalStationIds(departureStationId, arrivalStationId))
                .collect(Collectors.groupingBy(BusCoordinates::getRouteId, Collectors.counting()));
    }

    /**
     * Checks if there is any direct connection between stations
     * by checking if particular route has more than 1 station after filtering.
     * It uses logic of no duplicated bus coordinates (every stationId is zero or once in any route)
     *
     * @param routesMap Map where key is routeId and value is quantity of found station ids for particular route
     * @return {@code true} when route contains more than one entry
     */
    private Boolean isAnyDirectBusRouteBetweenStations(Map<Integer, Long> routesMap) {
        return routesMap.values().stream().anyMatch(quantity -> quantity > 1);
    }

    /**
     * Filters stream by departure and arrival stationIds
     *
     * @param departureStationId requested departure station id by a client to look for
     * @param arrivalStationId   requested arrival station id by a client to look for
     * @return
     */
    private Predicate<BusCoordinates> filterByDepartureAndArrivalStationIds(Integer departureStationId, Integer arrivalStationId) {
        return busCoordinates -> busCoordinates.getStationId() == departureStationId || busCoordinates.getStationId() == arrivalStationId;
    }
}
