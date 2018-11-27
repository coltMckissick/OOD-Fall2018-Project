package com.company;

import java.math.BigDecimal;

public class Bill {

    private BigDecimal _totalPrice;
    private boolean _isPaidInFull;
    private Payment _payment;

    public Bill(){
        _totalPrice = new BigDecimal(0);
        _isPaidInFull = false;
        _payment = new Payment();
    }

    public boolean applyPayment(Payment toApply, Trip trip){

        if(toApply.verify() && toApply.getAmount().equals(_totalPrice))
            _isPaidInFull = true;
        else
            _isPaidInFull = false;

        return _isPaidInFull;
    }

    public BigDecimal calculateTotalPrice(Trip trip){

        for (Reservation reservation:
                trip.getReservations()) {
            _totalPrice = _totalPrice.add(reservation.getPackage().getPrice());
        }

        return _totalPrice;
    }

    public boolean getIsPaidInFull(){
        return _isPaidInFull;
    }

    public void setIsPaidInFull(boolean isPaidInFull){
        _isPaidInFull = isPaidInFull;
    }

    public Payment getPayment(){
        return _payment;
    }

    public void setPayment(Payment payment){
        _payment = payment;
    }

}
