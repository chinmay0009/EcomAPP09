package com.mid.Ecomapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mid.Ecomapp.repository.ProductRepository;
import com.mid.Ecomapp.entity.Product;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product saveProduct(Product product) {
        product.setId(null);
        return productRepository.save(product);
    }

    public Product getProductByID(String id) {
        return productRepository.findById(id).get();
    }

    public List<Product> getProducts(){
        return productRepository.findAll();
    }
    //delete product
    public boolean deleteProductById(String id){
        Optional<Product> product = productRepository.findById(id);
        if (product.isEmpty()){
            return false;
        }
        productRepository.deleteById(id);
        return true;
    }
    //update
    public Product updateProduct(Product product,String id){
        Product existingProduct = productRepository.findById(id).get();
        existingProduct.setName(product.getName());
        existingProduct.setDescription(product.getDescription());
        existingProduct.setCategory(product.getCategory());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setTags(product.getTags());
        existingProduct.setStock(product.getStock());
        return  productRepository.save(existingProduct);
    }





}
