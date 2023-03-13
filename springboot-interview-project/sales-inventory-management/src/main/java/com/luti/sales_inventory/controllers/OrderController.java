package com.luti.sales_inventory.controllers;

import com.luti.sales_inventory.exception.CustomerDoesNotExistException;
import com.luti.sales_inventory.exception.OutOfStockException;
import com.luti.sales_inventory.exception.ProductDoesNotExistException;
import com.luti.sales_inventory.kafka.KafkaProducer;
import com.luti.sales_inventory.model.WebOrder;
import com.luti.sales_inventory.request.OrderRequest;
import com.luti.sales_inventory.response.BaseResponse;
import com.luti.sales_inventory.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/order")
public class OrderController {
    private final static String PRODUCT_DOES_NOT_EXIST = "Product does not exist";
    private final static String OUT_OF_STOCK = "Product is Out of Stock!";
    private final static String CUSTOMER_DOES_NOT_EXIST = "Customer does not exist";
    private final static String ORDER_CREATED = "Order Created Successfully!";
    private OrderService orderService;
    private KafkaProducer kafkaProducer;

    public OrderController(OrderService orderService, KafkaProducer kafkaProducer) {
        this.orderService = orderService;
        this.kafkaProducer = kafkaProducer;
    }

    @PostMapping("")
    private ResponseEntity<BaseResponse>makeOrder(@RequestBody OrderRequest request){
        BaseResponse response = new BaseResponse();
        try {
            WebOrder order = orderService.makeOrder(request);
            response.setSuccess(true);
            response.setData(order);
            response.setMsg(ORDER_CREATED);
            return ResponseEntity.status(201).body(response);
        } catch (ProductDoesNotExistException e) {
            response.setSuccess(false);
            response.setMsg(PRODUCT_DOES_NOT_EXIST);
            return ResponseEntity.status(404).body(response);
        }
        catch (OutOfStockException e){
            response.setSuccess(false);
            response.setMsg(OUT_OF_STOCK);
            return ResponseEntity.status(404).body(response);
        }
        catch (CustomerDoesNotExistException e){
            response.setSuccess(false);
            response.setMsg(CUSTOMER_DOES_NOT_EXIST);
            return ResponseEntity.status(404).body(response);
        }
    }
//    @PostMapping("/publish")
//    public ResponseEntity<String> publish(@RequestBody Userr user){
//        kafkaProducer.sendMessage(user);
//        return ResponseEntity.ok("Json message sent to kafka topic");
//    }
}
