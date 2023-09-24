package com.geektrust.backend.entites;

public enum PassengerType {
    ADULT(200),SENIOR_CITIZEN(100),KID(50);
    private final int price;
    PassengerType(int i) {
        price=i;
    }
    public Integer getPrice(){
        return price;
    }
}
