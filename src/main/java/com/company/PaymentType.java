package com.company;

import java.math.BigDecimal;

public abstract class PaymentType {

    protected BigDecimal _amount;

    protected PaymentType(BigDecimal amount){
        _amount = amount;
    }

    public abstract boolean verify();

    public BigDecimal getAmount(){
        return _amount;
    }

}
