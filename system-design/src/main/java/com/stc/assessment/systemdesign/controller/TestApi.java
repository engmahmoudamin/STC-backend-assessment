package com.stc.assessment.systemdesign.controller;


import com.stc.assessment.systemdesign.common.dto.SimpleResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * The interface Test api.
 */
@RequestMapping("/test")
public interface TestApi {

    /**
     * endpoint to test that the project is running
     *
     * @return ResponseEntity<SimpleResponseDto>  simple response contain a test message
     */
    @GetMapping
    ResponseEntity<SimpleResponseDto> test();
}
