package com.shoppingapp.admin.controller;

import com.shoppingapp.admin.entity.ProductEntity;
import com.shoppingapp.admin.exception.ApplicationException;
import com.shoppingapp.admin.model.Product;
import com.shoppingapp.admin.response.Response;
import com.shoppingapp.admin.service.AdminService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@SecurityRequirement(name = "admin-service")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1.0/shopping")
public class AdminController {

    private final AdminService service;

    private final KafkaTemplate<String, String> kafkaTemplate;

    @GetMapping("/status")
    public ResponseEntity<Response> getStatus() {
        return new ResponseEntity<Response>(new Response("Admin application is running!",HttpStatus.OK.value()),HttpStatus.OK);
    }

    @PostMapping(value = "/{productName}/add")
    public ResponseEntity<Response> addProduct(@PathVariable String productName, @RequestBody Product product) throws ApplicationException {
        try {
            product.setName(productName);
            Response response = service.addProduct(product);
            return new ResponseEntity<Response>(response,HttpStatus.valueOf(response.getStatus()));
        } catch (Exception e) {
            throw new ApplicationException(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value());
        }
    }

    @PutMapping(value = "/{productName}/update/{id}")
    public ResponseEntity<Response> updateProduct(@PathVariable String productName, @PathVariable int id, @RequestBody Product product) throws ApplicationException {
        try {
            // add an if exists check using product name
            product.setName(productName);
            Response response= service.updateProduct(product,id);
            return new ResponseEntity<>(response, HttpStatus.valueOf(response.getStatus()));
        } catch (Exception e) {
            throw new ApplicationException(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value());
        }
    }

    @DeleteMapping(value = "/{productName}/delete/{id}")
    public ResponseEntity<Response> deleteProduct(@PathVariable String productName, @PathVariable int id) throws ApplicationException {
        try {
            kafkaTemplate.send("deleteProduct", String.valueOf(id));
            Response response = new Response(productName + " marked for deletion!",HttpStatus.OK.value());
            return new ResponseEntity<>(response, HttpStatus.OK);

        } catch (Exception e) {
            throw new ApplicationException(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value());
        }
    }

}
