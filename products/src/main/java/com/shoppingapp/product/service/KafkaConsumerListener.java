package com.shoppingapp.product.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Slf4j
public class KafkaConsumerListener {

    @Autowired
    ProductService service;

    private static final String TOPIC = "deleteProduct";

    @KafkaListener(topics = TOPIC, groupId="group_id", containerFactory = "userKafkaListenerFactory")
    public void consumeId(String id) {
        log.info("Consumed JSON Message: " + id);
        service.deleteProduct(Integer.valueOf(id));
    }

}