package com.company;

import java.math.BigDecimal;

public class ItineraryAppendBill extends ItineraryDecorator {

    public ItineraryAppendBill(ItineraryComponent componentToDecorate){
        super(componentToDecorate);
    }

    @Override
    public String output(){

        StringBuilder toOutput = new StringBuilder(super.output());
        Bill bill = getTrip().getBill();
        Payment payment = bill.getPayment();
        Person person = payment.getCustomer();
        BigDecimal amount  = payment.getAmount();
        PaymentType paymentType = payment.getPaymentType();

        toOutput.append(System.lineSeparator());
        toOutput.append(System.lineSeparator());
        toOutput.append("Customer: " + person.getName());
        toOutput.append(System.lineSeparator());
        toOutput.append("Payed: " + amount);
        toOutput.append(System.lineSeparator());
        if(paymentType instanceof  PaymentTypeCash)
            toOutput.append("Payed with cash.");
        else if(paymentType instanceof  PaymentTypeCheck) {
            toOutput.append("Payed with check.");
            PaymentTypeCheck typeCheck = (PaymentTypeCheck)paymentType;
            toOutput.append(System.lineSeparator());
            toOutput.append("Check Number: " + typeCheck.getCheckNumber());
        }
        else {
            toOutput.append("Payed with credit.");
            toOutput.append(System.lineSeparator());
            PaymentTypeCredit typeCredit = (PaymentTypeCredit)paymentType;
            toOutput.append("Credit Card Number: " + typeCredit.getCreditCardNumber());
            toOutput.append(System.lineSeparator());
            toOutput.append("Expiration Date: " + typeCredit.getExpirationDate());
        }

        return toOutput.toString();
    }

}
