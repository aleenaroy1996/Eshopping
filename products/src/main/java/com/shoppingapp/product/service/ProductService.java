package com.shoppingapp.product.service;

import com.shoppingapp.product.constant.Constant;
import com.shoppingapp.product.entity.ProductEntity;
import com.shoppingapp.product.exception.ApplicationException;
import com.shoppingapp.product.model.Product;
import com.shoppingapp.product.repository.ProductRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    private final ProductRepo productRepo;

    private final NextSequenceService nextSequenceService;

    public void addProduct(Product product) throws ApplicationException {
        Optional<ProductEntity> productOptional = productRepo.findByName(product.getName());
        if (productOptional.isPresent()) {
            throw new ApplicationException("Product already exists!", HttpStatus.OK.value());
        }else{
            ModelMapper modelMapper = new ModelMapper();
            ProductEntity productEntity = modelMapper.map(product, ProductEntity.class);
            productEntity.setId(nextSequenceService.getNextSequence("productId"));
            if(product.getQuantityAvailable()>0) {
                productEntity.setStatus(Constant.HURRY_UP_TO_PURCHASE);
            }else{
                productEntity.setStatus(Constant.OUT_OF_STOCK);
            }
            productRepo.save(productEntity);
        }
    }

    public void deleteProduct(int id) {
        Optional<ProductEntity> productOptional = productRepo.findById(id);
        if(productOptional.isPresent()) {
            productRepo.deleteById(id);
            log.info(productOptional.get().getName() + " deleted");
        } else {
            log.info("Product Id not found in db");
        }


    }

    public void updateProduct(Product product, int id) throws ApplicationException {
        Optional<ProductEntity> productOptional = productRepo.findById(id);
        if(productOptional.isPresent()) {
            ProductEntity productEntity = productOptional.get();
            productEntity.setName(product.getName());
            productEntity.setDescription(product.getDescription());
            productEntity.setFeature(product.getFeature());
            productEntity.setPrice(product.getPrice());
            productEntity.setQuantityAvailable(product.getQuantityAvailable());
            if(productEntity.getQuantityAvailable()<=0){
                productEntity.setStatus(Constant.OUT_OF_STOCK);
            }
            else{
                productEntity.setStatus(Constant.HURRY_UP_TO_PURCHASE);
            }
            productRepo.save(productEntity);
        }
        else {
            log.info("Product Id not found in db");
            throw new ApplicationException("Product not found in db!",HttpStatus.OK.value());
        }
    }

    public List<ProductEntity> searchAllProducts() throws ApplicationException {
       // throw new ApplicationException("Test Exception!",HttpStatus.I.value());
        return productRepo.findAll();
    }

    public ProductEntity searchProduct(String productName) throws ApplicationException {
        //throw new ApplicationException("Test Exception!",HttpStatus.OK.value());
        Optional<ProductEntity> optionalProductEntity = productRepo.findByName(productName);
        if(optionalProductEntity.isEmpty()){
            throw new ApplicationException("Searched product not found!",HttpStatus.OK.value());
        }
        return optionalProductEntity.get();
    }
}
