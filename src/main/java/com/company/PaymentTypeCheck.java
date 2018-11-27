package com.company;

import java.math.BigDecimal;

public class PaymentTypeCheck extends PaymentType {

    private int _checkNumber;

    public PaymentTypeCheck(BigDecimal amount, int checkNumber){
        super(amount);
        _checkNumber = checkNumber;
    }

    @Override
    public boolean verify() {
        if(!_amount.equals(0)) {
            if(_checkNumber > 0)
                return true;
            else {
                System.out.println("Invalid check number");
                return false;
            }
        }
        else{
            System.out.println("Amount must be greater than 0");
            return false;
        }
    }

    public int getCheckNumber(){
        return _checkNumber;
    }
}
