package com.shypkao.dne.controller;

import com.shypkao.dne.model.DneRequest;
import com.shypkao.dne.service.DneService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequiredArgsConstructor
@Slf4j
public class DneRestController {

    public static final String SERVER_ENDPOINT = "/server";
    private final DneService dneService;

    @PostMapping(SERVER_ENDPOINT)
    public boolean checkDneSequence(@RequestBody DneRequest request) {
        try {
            int[] seq = request.getSeq();
            return dneService.hasDneSequence(seq);
        } catch (IllegalArgumentException ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage(), ex);
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "An error occurred", ex);
        }
    }

    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<ErrorResponse> handleResponseStatusException(ResponseStatusException ex) {
        HttpStatus status = ex.getStatus();
        String message = ex.getMessage();
        Throwable cause = ex.getCause();
        ErrorResponse errorResponse = new ErrorResponse(status.value(), message, cause != null ? cause.getMessage() : null);
        return ResponseEntity.status(status).body(errorResponse);
    }

    @Slf4j
    public static class ErrorResponse {
        private final int status;
        private final String message;
        private final String cause;

        public ErrorResponse(int status, String message, String cause) {
            this.status = status;
            this.message = message;
            this.cause = cause;
            log.error("Error response: status={}, message={}, cause={}", status, message, cause);
        }

        public int getStatus() {
            return status;
        }

        public String getMessage() {
            return message;
        }

        public String getCause() {
            return cause;
        }
    }

}
