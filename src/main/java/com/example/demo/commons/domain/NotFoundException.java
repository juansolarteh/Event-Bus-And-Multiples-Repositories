package com.example.demo.commons.domain;

public class NotFoundException extends RuntimeException{
    public NotFoundException(String message){
        super(message);
    }
}
