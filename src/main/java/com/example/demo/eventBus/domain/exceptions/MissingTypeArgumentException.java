package com.example.demo.eventBus.domain.exceptions;

public class MissingTypeArgumentException extends Exception{
    public MissingTypeArgumentException(){
        super("No type argument found in the event listener");
    }
}
