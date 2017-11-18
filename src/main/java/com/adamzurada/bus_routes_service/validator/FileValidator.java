package com.adamzurada.bus_routes_service.validator;

import lombok.experimental.UtilityClass;

import java.util.Arrays;

@UtilityClass
public class FileValidator {

    private static final int MIN_ROW_LENGTH = 3;
    /**
     * Validates file line as a string
     *
     * @param fileLine string to validate
     */
    public static void validateFileLine(String fileLine) {
        if (fileLine.trim().isEmpty()) {
            throw new RuntimeException();
        }
    }

    /**
     * Validates route data in string format for changing elements to integer type
     *
     * @param routeData array to validate
     * @return mapped integer array
     */
    public static int[] validateRouteDataAndMapToIntegerArray(String[] routeData) {
        if (routeData.length < MIN_ROW_LENGTH) {
            throw new RuntimeException();
        }
        try {
            return Arrays.stream(routeData).mapToInt(Integer::parseInt).toArray();
        } catch (NumberFormatException ex) {
            throw new RuntimeException();
        }

    }
}
