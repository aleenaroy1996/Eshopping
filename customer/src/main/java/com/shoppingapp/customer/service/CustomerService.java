package com.shoppingapp.customer.service;

import com.shoppingapp.customer.entity.ProductEntity;
import com.shoppingapp.customer.response.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final RestTemplate restTemplate;
    public Response searchAllProducts() {
        HttpEntity<?> entity = new HttpEntity<>(null,null);
        Response productResponse  = null;
        try {
            productResponse = restTemplate.exchange("lb://product/product/api/v1.0/shopping/all",
                    HttpMethod.GET, entity, Response.class).getBody();
        } catch (RestClientException e) {
            throw e;
        }
        return productResponse;
    }

    public Response searchProduct( String productName) {
        HttpEntity<?> entity = new HttpEntity<>(null,null);
        Response productResponse  = null;
        try {
            productResponse = restTemplate.exchange("lb://product/product/api/v1.0/shopping/products/search/"+productName,
                    HttpMethod.GET, entity, Response.class).getBody();
        } catch (RestClientException e) {
            throw e;
        }
        return productResponse;
    }
}
