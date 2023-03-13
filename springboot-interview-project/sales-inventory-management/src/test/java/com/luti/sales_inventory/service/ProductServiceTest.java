package com.luti.sales_inventory.service;

import com.luti.sales_inventory.exception.ProductDoesNotExistException;
import com.luti.sales_inventory.request.CreateProductRequest;
import com.luti.sales_inventory.request.UpdateProductRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
public class ProductServiceTest {

    @Autowired
    private ProductService productService;

    @Test
    @Transactional
    public void testCreateProduct(){
        CreateProductRequest product = new CreateProductRequest("Vaseline", "A very nice cream", 20, 4.95);
        Assertions.assertDoesNotThrow(()->productService.addProduct(product),"Product Added Successfully");
    }

    @Test
    @Transactional
    public void testUpdateProduct(){
        UpdateProductRequest product = new UpdateProductRequest("Rub", "A vey good balm", 10, 25.5);
        Assertions.assertThrows(ProductDoesNotExistException.class, ()-> productService.updateProduct(40L, product), "Product does not exist");
        Assertions.assertDoesNotThrow(()-> productService.updateProduct(1L, product), "Product updated successfully");

    }
    @Test
    @Transactional
    public void testGetAvailableProduct(){
        Assertions.assertDoesNotThrow(()->productService.getAllProducts(), "Returns all product where inStock is greater than zero");
    }
}
