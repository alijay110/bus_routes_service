package com.adamzurada.bus_routes_service.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    INVALID_REQUEST_PARAMS(1000, Constants.INVALID_REQUEST_PARAMS),
    FILE_READING_ERROR(1001, Constants.FILE_READING_ERROR_MSG),
    NO_DATA_LOADED_ON_THE_SERVER(1002, Constants.NO_DATA_LOADED_ON_THE_SERVER),
    FILE_HAS_NOT_ENOUGH_DATA(1003, Constants.FILE_HAS_NOT_ENOUGH_DATA),
    FILE_CONTAINS_INVALID_CHARACTERS(1004, Constants.FILE_CONTAINS_INVALID_CHARACTERS),
    DEP_AND_ARR_IDS_ARE_THE_SAME(1005,Constants.DEP_AND_ARR_IDS_ARE_THE_SAME );

    private final int code;
    private final String msg;

    public static class Constants {
        private final static String INVALID_REQUEST_PARAMS = "Invalid request parameters";
        private final static String FILE_READING_ERROR_MSG = "Error during reading the file";
        private final static String NO_DATA_LOADED_ON_THE_SERVER = "No bus provider data has been loaded to the server";
        private final static String FILE_HAS_NOT_ENOUGH_DATA = "Each row of bus route should contain at least 3 numbers";
        private final static String FILE_CONTAINS_INVALID_CHARACTERS = "The file should contain only numbers";
        private final static String DEP_AND_ARR_IDS_ARE_THE_SAME = "Departure and arrival ids must not be the same";
    }
}