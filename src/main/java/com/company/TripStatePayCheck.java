package com.company;

import java.math.BigDecimal;
import java.util.Scanner;

public class TripStatePayCheck extends TripState {
    public TripStatePayCheck(TripContext tripContext) {
        super(tripContext, Status.PayCheck);
    }

    @Override
    public TripStateLoop.Status execute() {

        BigDecimal amount = new BigDecimal(0);
        int checkNumber = 0;
        Bill bill = getTripContext().getTrip().getBill();
        PaymentType checkType;
        Payment check;
        Scanner scanner;

        System.out.println("---Pay Check---");
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
                    Person paying = AllPersons.getAllPersons().get(index);//select person who is paying

                    System.out.println("Enter check number: ");
                    if(scanner.hasNextInt()){

                        checkNumber = scanner.nextInt(); //get check number

                        System.out.println("Hello " + paying.getName() + ", enter the amount you would like to pay: ");
                        if(scanner.hasNextBigDecimal()) {
                            amount = scanner.nextBigDecimal();
                            checkType = new PaymentTypeCheck(amount, checkNumber);
                            check = new Payment(paying, checkType, amount);
                            if (check.verify()){ //Validate
                                bill.applyPayment(check, getTripContext().getTrip());
                                bill.setPayment(check);
                            }
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
