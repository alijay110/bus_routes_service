package com.adamzurada.bus_routes_service.performance;

import com.adamzurada.bus_routes_service.BusRoutesServiceApplicationTests;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = BusRoutesServiceApplicationTests.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_CLASS)
@Slf4j
public class MemoryConsumptionTest {

    /**
     * Purpose of this test is to show why I decided to go with int instead of Integer wrapping classes for my model.
     * It saves retained size approx. 32 bytes for each created object.
     */
    @Test
    public void givenBusCoordinatesObjects_whenComparingObjectSizesWithDifferentObjectVariableTypes_thenShowResultsOfMemoryTaken() {
        BusCoordinatesWithWrappers busCoordinatesWithWrappers = new BusCoordinatesWithWrappers();
        Integer integerValue = 678;
        BusCoordinatesWithPrimitives busCoordinatesWithPrimitives = new BusCoordinatesWithPrimitives();
        log.info("Each Integer wrapper class size: {}", PerformanceTestUtils.measureObjectSize(integerValue));
        log.info("Object retained size with wrapping Integers: {}", PerformanceTestUtils.measureObjectSize(busCoordinatesWithWrappers));
        log.info("Object retained size with primitive ints: {}", PerformanceTestUtils.measureObjectSize(busCoordinatesWithPrimitives));
        log.info("Object with wrappers takes {} more bytes.", PerformanceTestUtils.measureObjectSize(busCoordinatesWithWrappers) - PerformanceTestUtils.measureObjectSize(busCoordinatesWithPrimitives));
    }


    static class BusCoordinatesWithWrappers {
        private Integer routeId;
        private Integer stationId;

        public BusCoordinatesWithWrappers() {
            this.routeId = 444;
            this.stationId = 555;
        }
    }

    static class BusCoordinatesWithPrimitives {
        private int routeId;
        private int stationId;

        public BusCoordinatesWithPrimitives() {
            this.routeId = 444;
            this.stationId = 555;
        }
    }
}
