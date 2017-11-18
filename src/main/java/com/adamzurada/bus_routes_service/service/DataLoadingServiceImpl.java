package com.adamzurada.bus_routes_service.service;

import com.adamzurada.bus_routes_service.mapper.BusCoordinatesMapper;
import com.adamzurada.bus_routes_service.model.BusCoordinates;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Slf4j
@Service
public class DataLoadingServiceImpl implements DataLoadingService {

    private static final int FILE_HEADER_LINES = 1;
    private final BusCoordinatesMapper busCoordinatesMapper;
    private Set<BusCoordinates> busCoordinates;

    @Autowired
    public DataLoadingServiceImpl(BusCoordinatesMapper busCoordinatesMapper) {
        this.busCoordinatesMapper = busCoordinatesMapper;
    }

    @Override
    public Set<BusCoordinates> findAllBusCoordinates() {
        if (busCoordinates == null) {
            throw new RuntimeException();
        }
        return busCoordinates;
    }

    @Override
    public void loadBusRoutesCoordinatesFromFile(String absoluteFilePath) {
        busCoordinates = new HashSet<>();
        processInputFile(absoluteFilePath);
    }

    /**
     * Processes input file by reading line by line
     *
     * @param absoluteFilePath absolute path to a file
     */
    private void processInputFile(String absoluteFilePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(absoluteFilePath))) {
            br.lines().skip(FILE_HEADER_LINES).forEach(this::consumeLineOfData);
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }

    /**
     * Consumes line of data from the file
     *
     * @param line of file as String
     */
    private void consumeLineOfData(String line) {
        log.debug("Consuming file line: {}", line);
        busCoordinates.addAll(busCoordinatesMapper.mapFileLineToBusCoordinates(line));
    }
}
