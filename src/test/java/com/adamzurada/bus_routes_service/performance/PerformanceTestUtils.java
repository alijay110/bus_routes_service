package com.adamzurada.bus_routes_service.performance;

import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
import org.github.jamm.MemoryMeter;

@UtilityClass
@Slf4j
public class PerformanceTestUtils {

    private MemoryMeter meter = new MemoryMeter();

    /**
     * Checks object size.
     *
     * @param anObject to check
     * @return retained memory object size(with deep checking of references - how much would GC collect)
     */

    public long measureObjectSize(Object anObject) {
        log.debug("size: {} bytes", meter.measure(anObject));
        log.debug("retained size: {} bytes", meter.measureDeep(anObject));
        log.debug("inner object count: {}", meter.countChildren(anObject));
        return meter.measureDeep(anObject);
    }

}
