package com.shoppingapp.product.controller;

import com.shoppingapp.product.entity.ProductEntity;
import com.shoppingapp.product.exception.ApplicationException;
import com.shoppingapp.product.model.Product;
import com.shoppingapp.product.response.Response;
import com.shoppingapp.product.service.ProductService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Max;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product/api/v1.0/shopping")
public class ProductController {

    private final ProductService service;

    @GetMapping("/status")
    public ResponseEntity<Response> getStatus() {
        return new ResponseEntity<Response>(new Response("Product application is running!",HttpStatus.OK.value()),HttpStatus.OK);
    }

    @GetMapping(value = "/all")
    public ResponseEntity<Response> searchAllProducts() throws ApplicationException {
        try {
            List<ProductEntity> productEntityList = service.searchAllProducts();
            Response response = new Response();
            response.setProductEntityList(productEntityList);
            return new ResponseEntity<Response>(response,HttpStatus.OK);
        } catch (ApplicationException e) {
            throw e;
        }
        catch (Exception e) {
            throw new ApplicationException(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value());
        }
    }
    @GetMapping(value = "/products/search/{productName}")
    public ResponseEntity<Response> searchProduct(@PathVariable String productName) throws ApplicationException {
        try {
            ProductEntity productEntity = service.searchProduct(productName);
            Response response = new Response();
            response.setProductEntityList(List.of(productEntity));
            return new ResponseEntity<Response>(response,HttpStatus.OK);
        } catch (ApplicationException e) {
            throw e;
        }
        catch (Exception e) {
            throw new ApplicationException(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value());
        }
    }

    @PostMapping(value = "/{productName}/add")
    public ResponseEntity<Response> addProduct(@PathVariable String productName, @RequestBody Product product) throws ApplicationException {
        try {
            service.addProduct(product);
            return new ResponseEntity<Response>(new Response("Product added successfully!",HttpStatus.CREATED.value()),HttpStatus.CREATED);
        }
        catch (ApplicationException e) {
            throw e;
        }
        catch (Exception e) {
            throw new ApplicationException(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value());
        }
    }

    @PutMapping(value = "/{productName}/update/{id}")
    public ResponseEntity<Response> updateProduct(@PathVariable String productName, @PathVariable int id, @RequestBody Product product) throws ApplicationException {
        try {
            service.updateProduct(product,id);
            return new ResponseEntity<Response>(new Response("Product updated successfully!",HttpStatus.OK.value()),HttpStatus.OK);
        } catch (ApplicationException e) {
            throw e;
        }
        catch (Exception e) {
            throw new ApplicationException(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value());
        }
    }

}
