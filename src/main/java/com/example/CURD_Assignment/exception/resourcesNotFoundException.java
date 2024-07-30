package com.example.CURD_Assignment.exception;

public class resourcesNotFoundException extends RuntimeException{
    public resourcesNotFoundException(String id){
        super("Could not found the Product with id "+ id);
    }
}