package com.stc.assessment.systemdesign.exception;

public class ElementAlreadyExistsException extends RuntimeException {
    public ElementAlreadyExistsException(String message) {
        super(message);
    }
}
