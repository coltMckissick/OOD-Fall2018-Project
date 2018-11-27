package com.company;

import java.math.BigDecimal;
import java.util.Date;

public class PaymentTypeCredit extends PaymentType {

    private int _creditCardNumber;
    private Date _expirationDate;

    public PaymentTypeCredit(BigDecimal amount, int creditCardNumber, Date experationDate){
        super(amount);
        _creditCardNumber = creditCardNumber;
        _expirationDate = experationDate;
    }

    @Override
    public boolean verify() {
        if(!_amount.equals(0)) {
            if(_creditCardNumber > 0)
                if(_expirationDate.after(new Date()))
                    return true;
                else{
                    System.out.println("Date must be after today");
                    return false;
                }
            else {
                System.out.println("Invalid credit card number");
                return false;
            }
        }
        else{
            System.out.println("Amount must be greater than 0");
            return false;
        }

    }

    public int getCreditCardNumber(){
        return _creditCardNumber;
    }

    public Date getExpirationDate(){
        return _expirationDate;
    }
}
