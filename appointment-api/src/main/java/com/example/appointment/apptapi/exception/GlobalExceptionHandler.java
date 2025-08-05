package com.example.appointment.apptapi.exception;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.http.HttpStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleException(Exception ex) {
        ErrorResponse errorResponse = new ErrorResponse("An error occurred", ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
    class ErrorResponse {
        private String message;
        private String details;
    
        public ErrorResponse(String message, String details) {
            this.message = message;
            this.details = details;
        }
    
        public String getMessage() {
            return message;
        }
    
        public void setMessage(String message) {
            this.message = message;
        }
    
        public String getDetails() {
            return details;
        }
    
        public void setDetails(String details) {
            this.details = details;
        }
    
        @Override
        public String toString() {
            return "ErrorResponse{" +
                    "message='" + message + '\'' +
                    ", details='" + details + '\'' +
                    '}';
        }
    }
}
