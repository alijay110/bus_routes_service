package com.adamzurada.bus_routes_service.startup;


import com.adamzurada.bus_routes_service.service.DataLoadingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ApplicationStartup implements ApplicationListener<ApplicationReadyEvent> {

    private final DataLoadingService dataLoadingService;

    @Value("${file.path}")
    private String filePath;

    @Autowired
    public ApplicationStartup(DataLoadingService dataLoadingService) {
        this.dataLoadingService = dataLoadingService;
    }

    /**
     * This event is executed as late as conceivably possible to indicate that
     * the application is ready to service requests.
     */
    @Override
    public void onApplicationEvent(final ApplicationReadyEvent event) {
        log.info("Loading bus provider data using file path: {}", filePath);
        dataLoadingService.loadBusRoutesCoordinatesFromFile(filePath);
    }

}