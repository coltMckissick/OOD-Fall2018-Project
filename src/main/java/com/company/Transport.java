package com.company;

import java.math.BigDecimal;

public class Transport {

    private BigDecimal _pricePerHour;
    private Type _type;

    public Transport(Type type, BigDecimal pricePerHour){
        _type = type;
        _pricePerHour = pricePerHour;
    }

    public BigDecimal getPricePerHour(){
        return _pricePerHour;
    }

    public Type getType(){
        return _type;
    }

    public void setType(Type type){
        _type = type;
    }

    public enum Type{
        Limo,
        Yacht,
        Helicopter,
        PrivateJet
    }

}
