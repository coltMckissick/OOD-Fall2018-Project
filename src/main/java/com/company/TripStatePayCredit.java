package com.company;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class TripStatePayCredit extends TripState {
    public TripStatePayCredit(TripContext tripContext) {
        super(tripContext, Status.PayCredit);
    }

    @Override
    public TripStateLoop.Status execute() {

        BigDecimal amount = new BigDecimal(0);
        int creditCardNumber = 0;
        Date expirationDate;
        Bill bill = getTripContext().getTrip().getBill();
        PaymentType creditType;
        Payment credit;
        Scanner scanner;
        DateFormat formatter = new SimpleDateFormat("yyyy-MMM");

        System.out.println("---Pay Credit---");
        System.out.println();
        System.out.println("Total: " + bill.calculateTotalPrice(getTripContext().getTrip()));
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
                    Person paying = AllPersons.getAllPersons().get(index); //Select Person who is paying

                    System.out.println("Enter credit card number: ");
                    if(scanner.hasNextInt()){

                        creditCardNumber = scanner.nextInt(); //get credit card number

                        System.out.println("Enter the expiration date (yyyy-MMM): ");
                        if(scanner.hasNext()){

                            String expirationString = scanner.next().trim();
                            try {
                                expirationDate = formatter.parse(expirationString); //get expiration date
                            }catch (java.text.ParseException e){
                                System.out.println(e.getMessage());
                                continue;
                            }

                            System.out.println("Hello " + paying.getName() + ", enter the amount you would like to pay: ");
                            if(scanner.hasNextBigDecimal()) {
                                amount = scanner.nextBigDecimal();
                                creditType = new PaymentTypeCredit(amount, creditCardNumber, expirationDate);
                                credit = new Payment(paying, creditType, amount);
                                if (credit.verify()){ //Validate
                                    bill.applyPayment(credit, getTripContext().getTrip());
                                    bill.setPayment(credit);
                                }
                            }else{
                                continue;
                            }
                        }else{
                            continue;
                        }
                    }else{
                        continue;
                    }


                } else {
                    System.out.println("---Not an available person---");
                    continue;
                }
            }else if(returnLater(scanner.next())){
                return TripStateLoop.Status.Stop;
            }else{
                continue;
            }
        }

        getTripContext().setTripState(new TripStateAddThankYou(getTripContext()));
        return TripStateLoop.Status.Continue;
    }
}
