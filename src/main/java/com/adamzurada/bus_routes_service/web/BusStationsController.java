package com.adamzurada.bus_routes_service.web;

import com.adamzurada.bus_routes_service.dto.BusStationsConnectionRequestDto;
import com.adamzurada.bus_routes_service.dto.BusStationsConnectionResponseDto;
import com.adamzurada.bus_routes_service.service.BusStationsConnectionService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class BusStationsController {

    private final BusStationsConnectionService busStationsConnectionService;

    @GetMapping("/direct")
    public ResponseEntity<BusStationsConnectionResponseDto> checkDirectConnectionBetweenStations(@Valid BusStationsConnectionRequestDto dto) {
        return ResponseEntity.ok(busStationsConnectionService.checkIfExistsAnyDirectBusRouteBetweenStations(dto));
    }
}
