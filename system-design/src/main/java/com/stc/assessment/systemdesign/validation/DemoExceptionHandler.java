package com.stc.assessment.systemdesign.validation;

import com.stc.assessment.systemdesign.common.dto.SimpleResponseDto;
import com.stc.assessment.systemdesign.exception.ElementAlreadyExistsException;
import com.stc.assessment.systemdesign.exception.InvalidDataException;
import com.stc.assessment.systemdesign.exception.InvalidAccessPermissionException;
import com.stc.assessment.systemdesign.exception.NoElementFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@Slf4j
@ControllerAdvice
public class DemoExceptionHandler {
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NoElementFoundException.class)
    public ResponseEntity<SimpleResponseDto> handleNoElementFoundException(NoElementFoundException noElementFoundException) {
        return new ResponseEntity<>(new SimpleResponseDto(noElementFoundException.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(InvalidDataException.class)
    public ResponseEntity<SimpleResponseDto> handleInvalidDataException(InvalidDataException invalidDataException) {
        return new ResponseEntity<>(new SimpleResponseDto(invalidDataException.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ElementAlreadyExistsException.class)
    public ResponseEntity<SimpleResponseDto> handleElementAlreadyExistsException(ElementAlreadyExistsException elementAlreadyExistsException) {
        return new ResponseEntity<>(new SimpleResponseDto(elementAlreadyExistsException.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(InvalidAccessPermissionException.class)
    public ResponseEntity<SimpleResponseDto> handleNoAccessPermissionException(InvalidAccessPermissionException invalidAccessPermissionException) {
        return new ResponseEntity<>(new SimpleResponseDto(invalidAccessPermissionException.getMessage()), HttpStatus.UNAUTHORIZED);
    }

}
