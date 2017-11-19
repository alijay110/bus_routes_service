package com.adamzurada.bus_routes_service.performance;

import com.adamzurada.bus_routes_service.BusRoutesServiceApplicationTests;
import com.adamzurada.bus_routes_service.performance.service.PerformanceService;
import junit.framework.TestCase;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import static com.adamzurada.bus_routes_service.BusRoutesServiceApplicationTests.HUGE_DATA_FILE_PATH;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BusRoutesServiceApplicationTests.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_CLASS)
@Slf4j
public class TimeExecutionTest extends TestCase {

    @Autowired
    private PerformanceService performanceService;

    /**
     * This test shows how long time is each method executed.
     * Example results for checkifExistsAnyDirectBusRouteBetweenStations (16GB RAM, procesor 2.8 GHz Intel I7 4-core):
     *
     * PerformanceService.checkIfExistsAnyDirectBusRouteBetweenStations(Integer,Integer) executed in 35ms
     * PerformanceService.checkIfExistsAnyDirectBusRouteBetweenStations(Integer,Integer) executed in 14ms
     * PerformanceService.checkIfExistsAnyDirectBusRouteBetweenStations(Integer,Integer) executed in 11ms
     * PerformanceService.checkIfExistsAnyDirectBusRouteBetweenStations(Integer,Integer) executed in 12ms
     */
    @Test
    public void shouldLogExecutionTimeForLoadingData() {
        performanceService.loadBusRoutesCoordinatesFromFile(HUGE_DATA_FILE_PATH);
        performanceService.findAllBusCoordinates();
        assertTrue(performanceService.checkIfExistsAnyDirectBusRouteBetweenStations(20, 30).getHasDirectBusRoute());
        assertFalse(performanceService.checkIfExistsAnyDirectBusRouteBetweenStations(-1, 40).getHasDirectBusRoute());
        assertFalse(performanceService.checkIfExistsAnyDirectBusRouteBetweenStations(101, 10).getHasDirectBusRoute());
        assertTrue(performanceService.checkIfExistsAnyDirectBusRouteBetweenStations(40, 10).getHasDirectBusRoute());
    }
}
