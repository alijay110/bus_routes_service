package com.adamzurada.bus_routes_service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlElement;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BusStationsConnectionRequestDto {

    /**
     * Departure station ID
     */
    @NotNull
    private Integer dep_sid;

    /**
     * Arrival station ID
     */
    @NotNull
    private Integer arr_sid;
}
