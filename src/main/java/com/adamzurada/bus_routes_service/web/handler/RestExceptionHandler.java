package com.adamzurada.bus_routes_service.web.handler;


import com.adamzurada.bus_routes_service.dto.ErrorResponseDto;
import com.adamzurada.bus_routes_service.exception.CustomException;
import com.adamzurada.bus_routes_service.exception.ErrorCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class RestExceptionHandler {

    @ExceptionHandler({CustomException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponseDto handleCustomException(CustomException e) {
        log.error("Runtime Exception thrown: {}", e);
        return new ErrorResponseDto(e.getCode().getCode(), e.getDetails());
    }

    @ExceptionHandler({BindException.class})
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ErrorResponseDto handleRequestBodyNotValidException(BindException exception) {
        log.warn(exception.getMessage());
        return new ErrorResponseDto(ErrorCode.INVALID_REQUEST_PARAMS.getCode(), ErrorCode.INVALID_REQUEST_PARAMS.getMsg());
    }
}