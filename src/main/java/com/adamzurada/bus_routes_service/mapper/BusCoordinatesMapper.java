package com.adamzurada.bus_routes_service.mapper;

import com.adamzurada.bus_routes_service.model.BusCoordinates;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

import static com.adamzurada.bus_routes_service.validator.FileValidator.validateFileLine;
import static com.adamzurada.bus_routes_service.validator.FileValidator.validateRouteDataAndMapToIntegerArray;

@Component
public class BusCoordinatesMapper {

    private static final String WHITESPACE_REGEX = "\\s+";
    private static final int ROUTE_ID_POSITION = 0;
    private static final int STATIONS_IDS_BEGINNING_POSITION = 1;

    /**
     * Maps string line from the file to a set of {@link BusCoordinates}
     * Default route data should consist of:
     * - routeId at index 0
     * - stationId from index 1 or onward
     *
     * @param fileLine string line of file read by {@link java.io.BufferedReader}
     * @return HashSet of {@link BusCoordinates}
     */
    public Set<BusCoordinates> mapFileLineToBusCoordinates(String fileLine) {
        validateFileLine(fileLine);
        int[] routeData = mapFileLineToRouteData(fileLine);
        Set<BusCoordinates> busCoordinates = new HashSet<>();
        int routeId = routeData[ROUTE_ID_POSITION];
        for (int position = STATIONS_IDS_BEGINNING_POSITION; position < routeData.length; position++) {
            int stationId = routeData[position];
            BusCoordinates newBusCoordinates = new BusCoordinates(routeId, stationId);
            busCoordinates.add(newBusCoordinates);
        }
        return busCoordinates;
    }

    /**
     * Maps file line to route data as array of integers
     * Default route data should consist of:
     * - routeId at index 0
     * - stationId from index 1 or onward
     *
     * @param fileLine string line of file read by {@link java.io.BufferedReader}
     * @return array of integers as route data
     */
    private int[] mapFileLineToRouteData(String fileLine) {
        String[] routeDataAsStrings = fileLine.split(WHITESPACE_REGEX);
        return validateRouteDataAndMapToIntegerArray(routeDataAsStrings);
    }
}
