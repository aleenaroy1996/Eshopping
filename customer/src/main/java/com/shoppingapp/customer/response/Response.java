package com.shoppingapp.customer.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.shoppingapp.customer.entity.ProductEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response {
    private String message;
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private int status;
    List<ProductEntity> productEntityList;

    public Response(String message, int status) {
        this.message = message;
        this.status = status;
    }
}
