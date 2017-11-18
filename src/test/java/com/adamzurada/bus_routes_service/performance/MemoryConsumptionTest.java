package com.adamzurada.bus_routes_service.performance;

import com.adamzurada.bus_routes_service.BusRoutesServiceApplicationTests;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import static com.adamzurada.bus_routes_service.performance.PerformanceTestUtils.measureObjectSize;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BusRoutesServiceApplicationTests.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_CLASS)
@Slf4j
public class MemoryConsumptionTest {

    @Test
    public void givenBusCoordinatesObjects_whenComparingObjectSizesWithDifferentObjectVariableTypes_thenShowResultsOfMemoryTaken() {
        BusCoordinatesWithWrappers busCoordinatesWithWrappers = new BusCoordinatesWithWrappers();
        Integer integerValue = 678;
        BusCoordinatesWithPrimitives busCoordinatesWithPrimitives = new BusCoordinatesWithPrimitives();
        log.info("Each Integer wrapper class size: {}", measureObjectSize(integerValue));
        log.info("Object retained size with wrapping Integers: {}", measureObjectSize(busCoordinatesWithWrappers));
        log.info("Object retained size with primitive ints: {}", measureObjectSize(busCoordinatesWithPrimitives));
        log.info("Object with wrappers takes {} more bytes.", measureObjectSize(busCoordinatesWithWrappers) - measureObjectSize(busCoordinatesWithPrimitives));
    }


    static class BusCoordinatesWithWrappers {
        private Integer routeId;
        private Integer stationId;
        private Integer position;

        public BusCoordinatesWithWrappers() {
            this.routeId = 444;
            this.stationId = 555;
            this.position = 666;
        }
    }

    static class BusCoordinatesWithPrimitives {
        private int routeId;
        private int stationId;
        private int positionId;

        public BusCoordinatesWithPrimitives() {
            this.routeId = 444;
            this.stationId = 555;
            this.positionId = 666;
        }
    }
}
