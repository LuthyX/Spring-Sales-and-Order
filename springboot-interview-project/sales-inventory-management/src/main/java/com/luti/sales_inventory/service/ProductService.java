package com.luti.sales_inventory.service;

import com.luti.sales_inventory.exception.ProductDoesNotExistException;
import com.luti.sales_inventory.model.Product;
import com.luti.sales_inventory.repository.ProductRepository;
import com.luti.sales_inventory.request.CreateProductRequest;
import com.luti.sales_inventory.request.UpdateProductRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts(){
        return productRepository.findAvailableProducts();
    }

    public Product getProduct(Long id) throws ProductDoesNotExistException {
        Optional<Product> oproduct = productRepository.findById(id);
        if(!oproduct.isPresent()){
            throw new ProductDoesNotExistException();
        }
        Product product = oproduct.get();
        return product;
    }

    public Product addProduct(CreateProductRequest request){
        Product product = new Product();
        product.setName(request.getName());
        product.setDescription(request.getDescription());
        product.setInStock(request.getQuantity());
        product.setPrice(request.getPrice());
        productRepository.save(product);
        return product;
    }

    public Product updateProduct(Long id, UpdateProductRequest request) throws ProductDoesNotExistException {
        Product product = productRepository.findById(id).orElseThrow(ProductDoesNotExistException::new);
        if(request.getName()!= null){
            product.setName(request.getName());
        }
        if(request.getDescription()!= null){
            product.setDescription(request.getDescription());
        }
        if(request.getPrice()!= null){
            product.setPrice(request.getPrice());
        }
        if(request.getQuantity()!= null){
            product.setInStock(request.getQuantity());
        }
        productRepository.save(product);
        return product;
    }
}
