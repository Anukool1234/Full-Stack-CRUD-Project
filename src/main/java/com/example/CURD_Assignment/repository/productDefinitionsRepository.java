package com.example.CURD_Assignment.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.CURD_Assignment.model.Product;

public interface productDefinitionsRepository extends MongoRepository<Product, String> {

}
