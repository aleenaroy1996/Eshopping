package com.shoppingapp.product.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.shoppingapp.product.entity.ProductEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

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
