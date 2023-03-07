package com.shoppingapp.admin.service;

import com.shoppingapp.admin.entity.ProductEntity;
import com.shoppingapp.admin.model.Product;
import com.shoppingapp.admin.response.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AdminServiceTest {

    @Mock
    private RestTemplate mockRestTemplate;

    private AdminService adminServiceUnderTest;

    @BeforeEach
    void setUp() {
        adminServiceUnderTest = new AdminService(mockRestTemplate);
    }

    @Test
    void testAddProduct() {
        // Setup
        final Product product = new Product("testproduct", "testproduct", "nofeature", "HURRY UP TO PURCHASE", 10.0, 10);
        final Response expectedResult = new Response("Product added successfully!", 201);

        // Configure RestTemplate.exchange(...).
        final ResponseEntity<Response> responseResponseEntity = new ResponseEntity<Response>(expectedResult,HttpStatus.valueOf(expectedResult.getStatus()));

        when(mockRestTemplate.exchange(eq("lb://product/api/v1.0/shopping/"+product.getName()+"/add/"), eq(HttpMethod.POST), eq(new HttpEntity(product, null)), eq(Response.class),
                any(Object.class))).thenReturn(responseResponseEntity);

        // Run the test
        final Response result = adminServiceUnderTest.addProduct(product);

        // Verify the results
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void testAddProduct_RestTemplateThrowsRestClientException() {
        // Setup
        final Product product = new Product("name", "description", "feature", "status", 0.0, 0);
        when(mockRestTemplate.exchange(eq("lb://product/api/v1.0/shopping/"+product.getName()+"/add/"), eq(HttpMethod.POST), eq(new HttpEntity(product, null)), eq(Response.class),
                any(Object.class))).thenThrow(RestClientException.class);

        // Run the test
        assertThatThrownBy(() -> adminServiceUnderTest.addProduct(product)).isInstanceOf(RestClientException.class);
    }

    @Test
    void testUpdateProduct() {
        // Setup
        final Product product = new Product("testproduct", "testproduct", "nofeature", "HURRY UP TO PURCHASE", 10.0, 10);
        final Response expectedResult = new Response("Product updated successfully!", 201);
        final int id=1;
        // Configure RestTemplate.exchange(...).
        final ResponseEntity<Response> responseResponseEntity = new ResponseEntity<Response>(expectedResult,HttpStatus.valueOf(expectedResult.getStatus()));

        when(mockRestTemplate.exchange(eq("lb://product/api/v1.0/shopping/"+product.getName()+"/update/"+id), eq(HttpMethod.PUT), eq(new HttpEntity(product, null)), eq(Response.class),
                any(Object.class))).thenReturn(responseResponseEntity);

        // Run the test
        final Response result = adminServiceUnderTest.updateProduct(product, id);

        // Verify the results
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void testUpdateProduct_RestTemplateThrowsRestClientException() {
        // Setup
        final Product product = new Product("name", "description", "feature", "status", 0.0, 0);
        final int id=1;
        when(mockRestTemplate.exchange(eq("lb://product/api/v1.0/shopping/"+product.getName()+"/update/"+id), eq(HttpMethod.PUT), eq(new HttpEntity(product, null)), eq(Response.class),
                any(Object.class))).thenThrow(RestClientException.class);

        // Run the test
        assertThatThrownBy(() -> adminServiceUnderTest.updateProduct(product, id))
                .isInstanceOf(RestClientException.class);
    }
}
