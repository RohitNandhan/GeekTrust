package com.geektrust.backend.exceptions;

public class PaymentFailedException extends Exception{
    public PaymentFailedException(){}
    public PaymentFailedException(String msg){
        super(msg);
    }
}
