package com.shoppingapp.customer.controller;

import com.shoppingapp.customer.exception.ApplicationException;
import com.shoppingapp.customer.response.Response;
import com.shoppingapp.customer.service.CustomerService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("/customer/api/v1.0/shopping")
public class CustomerController {
    private final CustomerService service;

    @GetMapping("/status")
    public ResponseEntity<Response> getStatus() {
        return new ResponseEntity<Response>(new Response("Customer application is running!", HttpStatus.OK.value()),HttpStatus.OK);
    }

    @GetMapping(value = "/all")
    public ResponseEntity<Response> searchAllProducts() throws ApplicationException {
        try {
            Response response = service.searchAllProducts();
            return new ResponseEntity<Response>(response,HttpStatus.OK);
        }
        catch (Exception e) {
            throw new ApplicationException(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value());
        }
    }

    @GetMapping(value = "/products/search/{productName}")
    public ResponseEntity<Response> searchProduct(@PathVariable String productName) throws ApplicationException {
        try {
            Response response = service.searchProduct(productName);
            return new ResponseEntity<Response>(response,HttpStatus.OK);
        }
        catch (Exception e) {
            throw new ApplicationException(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value());
        }
    }



}
