package com.example.springcore.exception;

import com.example.springcore.dto.ResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
@Slf4j    // -->> bu logging uchun annotation
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({Exception.class, Throwable.class})
    public final ResponseEntity<Object> handleCustomException(Exception ex) {
        String message = getLastCause(ex);
        log.error(message, ex);
        return new ResponseEntity<>(new ResponseDto<>(ResponseDto.States.ERROR, 500, ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(GenericNotFoundException.class)
    public final ResponseEntity<Object> handleGenericNotFoundException(Exception ex) {
        String message = getLastCause(ex);
        log.error(message, ex);
        return new ResponseEntity<>(new ResponseDto<>(ResponseDto.States.ERROR, 404, message), HttpStatus.NOT_FOUND);
    }


    private String getLastCause(Throwable throwable) {
        return throwable.getCause() == null ? (throwable.getLocalizedMessage() == null ? throwable.getMessage()
                : throwable.getLocalizedMessage()) : getLastCause(throwable.getCause());
    }

}
