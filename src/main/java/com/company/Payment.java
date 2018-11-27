package com.company;

import sun.awt.image.GifImageDecoder;

import java.math.BigDecimal;

public class Payment {

    private Person _customer;
    private PaymentType _paymentType;
    private BigDecimal _amount;

    public Payment(){
        _amount = new BigDecimal(0);
    }

    public Payment(Person customer, PaymentType paymentType, BigDecimal amount){
        _customer = customer;
        _paymentType = paymentType;
        _amount = amount;
    }

    public boolean verify(){
        return _paymentType.verify();
    }

    public BigDecimal getAmount(){
        return _amount;
    }

    public void setAmount(BigDecimal amount){
        _amount = amount;
    }

    public PaymentType getPaymentType() {
        return _paymentType;
    }

    public void setPaymentType(PaymentType paymentType){
        _paymentType = paymentType;
    }

    public Person getCustomer(){
        return _customer;
    }

    public void setCustomer(Person customer){
        _customer = customer;
    }
}
