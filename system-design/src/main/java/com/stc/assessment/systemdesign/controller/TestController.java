package com.stc.assessment.systemdesign.controller;

import com.stc.assessment.systemdesign.common.dto.SimpleResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

/**
 * The type Test controller.
 */
@RestController
public class TestController implements TestApi {

    /**
     * endpoint to test that the project is running
     *
     * @return ResponseEntity<SimpleResponseDto> simple response contain a test message
     */
    @Override
    public ResponseEntity<SimpleResponseDto> test() {
        return new ResponseEntity<>(new SimpleResponseDto("STC Demo App is Running"), HttpStatus.OK);
    }
}
