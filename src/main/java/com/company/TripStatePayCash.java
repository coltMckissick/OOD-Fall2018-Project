package com.company;

import java.math.BigDecimal;
import java.util.Scanner;

public class TripStatePayCash extends TripState {
    public TripStatePayCash(TripContext tripContext) {
        super(tripContext, Status.PayCash);
    }

    @Override
    public TripStateLoop.Status execute() {

        BigDecimal amount = new BigDecimal(0);
        Bill bill = getTripContext().getTrip().getBill();
        BigDecimal totalPrice = bill.calculateTotalPrice(getTripContext().getTrip());
        PaymentType cashType;
        Payment cash;
        Scanner scanner;

        System.out.println("---Pay Cash---");
        System.out.println();
        System.out.println("Total: " + totalPrice);
        System.out.println();

        while(!bill.getIsPaidInFull()){
            scanner = new Scanner(System.in);

            //Load & display available people from the AllPersons singleton

            System.out.println("---Available People---");
            for(int i = 0; i < AllPersons.getAllPersons().size(); i++){
                System.out.println(i + ": " + AllPersons.getAllPersons().get(i).toString());
            }
            System.out.println("Enter the number of the person who is paying: ");
            if(scanner.hasNextInt()) {
                int index = scanner.nextInt();
                if(index < AllPersons.getAllPersons().size()) {
                    Person paying = AllPersons.getAllPersons().get(index); //select the person who is paying

                    System.out.println("Hello " + paying.getName() + ", enter the amount you would like to pay: ");
                    if(scanner.hasNextBigDecimal()) {
                        amount = scanner.nextBigDecimal();
                        cashType = new PaymentTypeCash(amount);
                        cash = new Payment(paying, cashType, amount);
                        if (cash.verify()){ //validate payment
                            if(bill.applyPayment(cash, getTripContext().getTrip()))
                                bill.setPayment(cash);
                        }
                    }

                } else {
                    System.out.println("---Not an available person---");
                    continue;
                }
            }else if(returnLater(scanner.next())){
                return TripStateLoop.Status.Stop;
            }
            else{
                continue;
            }
        }

        getTripContext().setTripState(new TripStateAddThankYou(getTripContext()));
        return TripStateLoop.Status.Continue;
    }
}
