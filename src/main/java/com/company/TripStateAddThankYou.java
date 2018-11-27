package com.company;

import java.util.Scanner;

public class TripStateAddThankYou extends TripState {
    public TripStateAddThankYou(TripContext tripContext) {
        super(tripContext, Status.AddThankYou);
    }

    @Override
    public TripStateLoop.Status execute() {
        System.out.println(System.lineSeparator());
        System.out.println("*** ADD THANK YOU ***");
        System.out.println();
        System.out.println("- COMMAND: [later] to return later or write thank you note (5 chars min)");

        Scanner scanner = new Scanner(System.in);
        boolean getThankYou = true;
        String thankYou = null;



        while (getThankYou) {
            thankYou = scanner.nextLine().trim();

            if (returnLater(thankYou)) return TripStateLoop.Status.Stop;

            getThankYou = !IsThankYouValid(thankYou);
        }

        getTripContext().getTrip().setThankYou(thankYou);
        getTripContext().setTripState(new TripStateComplete(getTripContext()));
        return TripStateLoop.Status.Continue;
    }

    private boolean IsThankYouValid(String thankYou) {
        if (thankYou.isEmpty()){
            System.out.println("- ERROR: Thank You cannot be empty");
            return false;
        }

        if (thankYou.length() < 5) {
            System.out.println("- ERROR: Thank you must be at least 5 characters");
            return false;
        }

        return true;
    }
}
