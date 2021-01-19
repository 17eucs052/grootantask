package com.gokulg.training.exceptions;

public class KeyAlreadyPresentException extends RuntimeException{
    public KeyAlreadyPresentException(String message){
        super(message);
    }
}