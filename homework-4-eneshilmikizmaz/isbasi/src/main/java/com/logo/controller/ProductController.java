package com.logo.controller;

import com.logo.model.Customer;
import com.logo.model.Product;
import com.logo.model.User;
import com.logo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;
@RestController
@RequestMapping(value = "products")
public class ProductController {
    @Autowired
    ProductService productService;

    @PostMapping
    public Product createProduct(@RequestBody Product productRequest) {
        return productService.createProduct(productRequest);
    }

    @GetMapping
    public List<Product> getAllProduct() {
        return productService.getAllProducts();
    }

    @PutMapping
    public Product updateProduct(Product product) {
        return productService.updateProduct(product);
    }

    @DeleteMapping
    @ResponseStatus(code = HttpStatus.OK)
    public void deleteCustomer(@PathParam("productId") int productId) {
        productService.deleteProductById(productId);
    }
}
