package com.adamzurada.bus_routes_service.validator;

import com.adamzurada.bus_routes_service.exception.CustomException;
import com.adamzurada.bus_routes_service.exception.ErrorCode;
import lombok.experimental.UtilityClass;

import java.util.Arrays;

@UtilityClass
public class FileValidator {

    private static final int MIN_LINE_LENGTH = 3;
    private static final int MIN_LINE_QUANTITY = 2;
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
        if (routeData.length < MIN_LINE_LENGTH) {
            throw new CustomException(ErrorCode.FILE_HAS_NOT_ENOUGH_DATA);
        }
        try {
            return Arrays.stream(routeData).mapToInt(Integer::parseInt).toArray();
        } catch (NumberFormatException ex) {
            throw new CustomException(ErrorCode.FILE_CONTAINS_INVALID_CHARACTERS);
        }

    }
}
