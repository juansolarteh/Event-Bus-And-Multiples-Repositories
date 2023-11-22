package com.example.demo.shared.domain.eventBus.exceptions;

public class MissingTypeArgumentException extends Exception{
    public MissingTypeArgumentException(){
        super("No type argument found in the event listener");
    }
}
