package com.adamzurada.bus_routes_service.service;

import com.adamzurada.bus_routes_service.BusRoutesServiceApplicationTests;
import com.adamzurada.bus_routes_service.dto.BusStationsConnectionRequestDto;
import com.adamzurada.bus_routes_service.exception.CustomException;
import junit.framework.TestCase;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import static com.adamzurada.bus_routes_service.BusRoutesServiceApplicationTests.EXAMPLE_DATA_FILE_PATH;
import static com.adamzurada.bus_routes_service.BusRoutesServiceApplicationTests.ILLEGAL_CHARACTERS_DATA_FILE_PATH;
import static com.adamzurada.bus_routes_service.BusRoutesServiceApplicationTests.NOT_EXISTING_FILE_PATH;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BusRoutesServiceApplicationTests.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_CLASS)
@Slf4j
public class DataLoadingServiceTest extends TestCase {

    @Autowired
    private DataLoadingService dataLoadingService;

    @Autowired
    private BusStationsConnectionService busStationsConnectionService;

    @Test
    public void givenDepAndArrSid_whenLoadingDataAndCheckingDirectConnection_thenReturnValidValues() {
        dataLoadingService.loadBusRoutesCoordinatesFromFile(EXAMPLE_DATA_FILE_PATH);
        log.info("All Bus coordinates: {}", dataLoadingService.findAllBusCoordinates());
        assertTrue(busStationsConnectionService.checkIfExistsAnyDirectBusRouteBetweenStations(new BusStationsConnectionRequestDto(121, 114)).getHasDirectBusRoute());
        assertFalse(busStationsConnectionService.checkIfExistsAnyDirectBusRouteBetweenStations(new BusStationsConnectionRequestDto(121, -1)).getHasDirectBusRoute());
        assertFalse(busStationsConnectionService.checkIfExistsAnyDirectBusRouteBetweenStations(new BusStationsConnectionRequestDto(2, 121)).getHasDirectBusRoute());
        assertTrue(busStationsConnectionService.checkIfExistsAnyDirectBusRouteBetweenStations(new BusStationsConnectionRequestDto(169, 11)).getHasDirectBusRoute());
    }

    @Test(expected = CustomException.class)
    public void givenInvalidFile_whenLoadingData_thenReturnError(){
        dataLoadingService.loadBusRoutesCoordinatesFromFile(NOT_EXISTING_FILE_PATH);
    }

    @Test(expected = CustomException.class)
    public void givenFileWithIllegalCharacters_whenLoadingData_thenReturnError(){
        dataLoadingService.loadBusRoutesCoordinatesFromFile(ILLEGAL_CHARACTERS_DATA_FILE_PATH);
    }


}
