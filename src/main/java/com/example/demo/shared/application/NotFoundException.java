package com.example.demo.shared.application;

public class NotFoundException extends RuntimeException{
    public NotFoundException(String message){
        super(message);
    }
}
