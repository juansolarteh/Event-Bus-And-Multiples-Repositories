package com.example.demo.commons.eventBus.domain.exceptions;

public class MissingTypeArgumentException extends Exception{
    public MissingTypeArgumentException(){
        super("No type argument found in the event listener");
    }
}
