package com.shoppingapp.customer.exception;

import com.shoppingapp.customer.response.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApplicationExceptionController {
    @ExceptionHandler(value = ApplicationException.class)
    public ResponseEntity<Response> exception(ApplicationException exception) {
        Response response = new Response(exception.getMessage()
                , exception.getStatusCode());
        return  new ResponseEntity<>(response, HttpStatus.valueOf(response.getStatus()));
    }
}

