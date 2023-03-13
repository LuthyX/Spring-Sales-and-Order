package com.luti.sales_inventory.controllers;

import com.luti.sales_inventory.exception.ProductDoesNotExistException;
import com.luti.sales_inventory.model.Product;
import com.luti.sales_inventory.request.CreateProductRequest;
import com.luti.sales_inventory.request.UpdateProductRequest;
import com.luti.sales_inventory.response.BaseResponse;
import com.luti.sales_inventory.response.ListResponse;
import com.luti.sales_inventory.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {
    private final static String PRODUCT_ADDED = "Product Added Successfully";
    private final static String PRODUCT_UPDATED = "Product Updated Successfully";
    private final static String PRODUCT_DOES_NOT_EXIST = "Product does not exist";
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping()
    private ResponseEntity<ListResponse> getProducts(){
        List<Product> products = productService.getAllProducts();
        ListResponse response = new ListResponse();
        response.setSuccess(true);
        response.setData(products);
        return ResponseEntity.status(200).body(response);
    }

    @PostMapping()
    private ResponseEntity<BaseResponse> addProducts(@RequestBody CreateProductRequest request){

        BaseResponse response = new BaseResponse();
        Product product = productService.addProduct(request);
        response.setSuccess(true);
        response.setData(product);
        response.setMsg(PRODUCT_ADDED);
        return ResponseEntity.status(201).body(response);
    }

    @PutMapping("/{id}")
    private ResponseEntity<BaseResponse>updateProduct(@PathVariable Long id,  @RequestBody UpdateProductRequest request){
        BaseResponse response = new BaseResponse();
        try {
            Product product = productService.updateProduct(id, request);
            response.setSuccess(true);
            response.setData(product);
            response.setMsg(PRODUCT_UPDATED);
            return ResponseEntity.status(200).body(response);
        } catch (ProductDoesNotExistException e) {
            response.setSuccess(false);
            response.setMsg(PRODUCT_DOES_NOT_EXIST);
            return ResponseEntity.status(404).body(response);
        }
    }
}
