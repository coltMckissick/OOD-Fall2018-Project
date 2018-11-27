package com.company;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.Date;

public class TripStateAddReservation extends TripState {
    public TripStateAddReservation(TripContext tripContext) {
        super(tripContext, Status.AddReservation);
    }

    @Override
    public TripStateLoop.Status execute(){

        Scanner scanner;

        //Format for the depart and arrive dates
        DateFormat formatter = new SimpleDateFormat("yyyy-MMM-d,HH:mm");

        System.out.println();
        System.out.println("*** ADD RESERVATIONS ***");
        System.out.println();

        Boolean getReservations = true;
        while (getReservations) {

            scanner = new Scanner(System.in);
            System.out.println("Enter the day (yyyy-MMM-d,HH:mm) you would like to depart or type 'done': ");
            String departString = scanner.next().trim();
            if (continueEnteringReservations(departString) && !returnLater(departString)) {
                Date depart = new Date();
                try {
                    depart = formatter.parse(departString);
                } catch (java.text.ParseException e) {
                    System.out.println(e.getMessage());
                    continue;
                }

                //Load & display all packages from the AllPackages Singleton

                System.out.println("---Available Packages---");//UI selectable list later
                for (int i = 0; i < AllPackages.getAllPackages().size(); i++) {
                    System.out.println(i + ": " + AllPackages.getAllPackages().get(i).toString());
                }
                System.out.println("Enter the number of the package you would like to add or type: ");
                if (scanner.hasNextInt()) {
                    int index = scanner.nextInt();
                    if (index < AllPackages.getAllPackages().size()) {

                        //Add package to the reservation object, and add the reservation to the trip's reservation list
                        Package toAdd = AllPackages.getAllPackages().get(index);
                        getTripContext().getTrip().getReservations().add(new Reservation(depart, toAdd));
                    } else {
                        System.out.println("---Not an available package---");
                        continue;
                    }
                } else
                    continue;
            }else if(returnLater(departString)){
                return TripStateLoop.Status.Stop;
            }
            else
                getReservations = false;
        }
        getTripContext().setTripState(new TripStateChoosePaymentType(getTripContext()));
        return TripStateLoop.Status.Continue;

    }

    private Boolean continueEnteringReservations(String answer){
        boolean done = answer.toLowerCase().equals("done");

        if(done && !getTripContext().getTrip().getReservations().isEmpty()){
            System.out.println();
            System.out.println("*** RESERVATIONS FINISHED: " + getTripContext().getTrip().getReservations().size() + " entered ***");
        }else
            done = false;

        return !done;
    }
}
