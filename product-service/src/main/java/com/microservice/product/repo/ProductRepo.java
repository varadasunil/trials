package com.microservice.product.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.microservice.product.model.Product;

@Repository
public interface ProductRepo extends MongoRepository<Product, String>{

}
