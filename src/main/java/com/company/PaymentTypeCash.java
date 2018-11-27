package com.company;

import java.math.BigDecimal;

public class PaymentTypeCash extends PaymentType {

    public PaymentTypeCash(BigDecimal amount){
        super(amount);
    }

    @Override
    public boolean verify() {
        if(!_amount.equals(0))
            return true;
        else{
            System.out.println("Amount must be greater than 0.");
            return false;
        }
    }

}
