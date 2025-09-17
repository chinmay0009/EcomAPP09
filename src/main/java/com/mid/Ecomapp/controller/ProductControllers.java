package com.mid.Ecomapp.controller;

import com.mid.Ecomapp.entity.Product;
import com.mid.Ecomapp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@CrossOrigin("*")
public class ProductControllers {

    @Autowired
     private ProductService productService;


    @PostMapping("/save")
    public Product save(@RequestBody Product product){
        return  productService.saveProduct(product);
    }

    @GetMapping("/id")
    public  Product findById(@PathVariable String id){
        return productService.getProductByID(id);
    }

   @GetMapping("/all")
    public List<Product> findAll(){
        return productService.getProducts();
   }

   @PutMapping("/")
    public Product updateProduct(@RequestBody Product product,String id){
        return productService.updateProduct(product,id);
   }

   @DeleteMapping("/id")
   public  boolean deleteproduct(String id){
        return productService.deleteProductById(id);
   }




}
