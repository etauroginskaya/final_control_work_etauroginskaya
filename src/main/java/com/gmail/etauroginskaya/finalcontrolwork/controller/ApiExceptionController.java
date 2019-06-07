package com.gmail.etauroginskaya.finalcontrolwork.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.gmail.etauroginskaya.finalcontrolwork.constants.UrlConstants.API_DENIED_URL;

@RestController
public class ApiExceptionController {

    @GetMapping(API_DENIED_URL)
    public ResponseEntity<ApiError> error403() {
        return new ResponseEntity<>(new ApiError("Access Denied"), HttpStatus.FORBIDDEN);
    }

    class ApiError {

        private String message;

        public ApiError(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }
}
