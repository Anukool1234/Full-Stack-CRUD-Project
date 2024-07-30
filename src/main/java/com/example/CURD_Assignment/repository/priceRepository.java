package com.example.CURD_Assignment.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.CURD_Assignment.model.Price;

public interface priceRepository extends MongoRepository<Price, String> {

}
