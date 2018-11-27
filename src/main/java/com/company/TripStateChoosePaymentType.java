package com.company;

import java.util.Scanner;

public class TripStateChoosePaymentType extends TripState {
    public TripStateChoosePaymentType(TripContext tripContext) {
        super(tripContext, Status.ChoosePaymentType);
    }

    @Override
    public TripStateLoop.Status execute() {
        System.out.println(System.lineSeparator());
        System.out.println("*** CHOOSE PAYMENT TYPE ***");
        System.out.println();
        System.out.println("- COMMAND: [later] to return later, [cash], [check], [credit]");

        Scanner scanner = new Scanner(System.in);

        while (true)
        {

            //Next state dependent on payment type selected
            String paymentType = new String();

            if(scanner.hasNext())
                paymentType = scanner.next().trim();

            if (returnLater(paymentType)) return TripStateLoop.Status.Stop; //exit loop and method

            //empty entry does nothing
            if (paymentType.isEmpty()) continue;

            if (paymentType.equals("cash"))
            {
                getTripContext().setTripState(new TripStatePayCash(getTripContext()));
                return TripStateLoop.Status.Continue;
            }

            if (paymentType.equals("check"))
            {
                getTripContext().setTripState(new TripStatePayCheck(getTripContext()));
                return TripStateLoop.Status.Continue;
            }

            if (paymentType.equals("credit"))
            {
                getTripContext().setTripState(new TripStatePayCredit(getTripContext()));
                return TripStateLoop.Status.Continue;
            }

            System.out.println("- ERROR: [later], [cash], [check], or [credit]");
        }
    }
}
