package com.mid.Ecomapp.repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.mid.Ecomapp.entity.Product;

public interface ProductRepository extends MongoRepository<Product,String> {

}
