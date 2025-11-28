package com.example.BlogApplication.Exception;

public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException(String message){
            super(message);
    }

}
