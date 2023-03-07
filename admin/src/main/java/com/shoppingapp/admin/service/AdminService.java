package com.shoppingapp.admin.service;

import com.shoppingapp.admin.model.Product;
import com.shoppingapp.admin.response.Response;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
@Slf4j
@Service
@RequiredArgsConstructor
public class AdminService {

    private final RestTemplate restTemplate;

    public Response addProduct(Product product) {
        HttpEntity<?> entity = new HttpEntity(product, null);
        Response productResponse  = null;
        try {
            productResponse = restTemplate.exchange("lb://product/api/v1.0/shopping/"+product.getName()+"/add/",
                    HttpMethod.POST, entity, Response.class).getBody();
        }
        catch (RestClientException e) {
            throw e;
        }
        return productResponse;
    }


    public Response updateProduct(Product product, int id) {
        HttpEntity<?> entity = new HttpEntity(product, null);
        Response productResponse  = null;
        try {
            productResponse = restTemplate.exchange("lb://product/api/v1.0/shopping/"+product.getName()+"/update/"+id,
                    HttpMethod.PUT, entity, Response.class).getBody();
        } catch (RestClientException e) {
            throw e;
        }
        return productResponse;
    }
}
