package com.company;

import java.util.Scanner;

public class TripStateAddTraveller extends TripState {

    public TripStateAddTraveller(TripContext context) {
        super(context, Status.AddTraveller);
    }

    @Override
    public TripStateLoop.Status execute() {

        Scanner scanner;

        System.out.println();
        System.out.println("*** ADD TRAVELLERS ***");
        System.out.println();

        Boolean getTravellers = true;
        while (getTravellers){

            scanner = new Scanner(System.in);

            //Load & Display Travellers from the AllPersons singleton

            System.out.println("---Available Travellers---");
            System.out.println("Type [later] at anytime to continue later");
            for(int i = 0; i < AllPersons.getAllPersons().size(); i++){
                System.out.println(i + ": " + AllPersons.getAllPersons().get(i).toString());
            }
            System.out.println("Enter the number of the traveller you would like to add or type 'done': ");
            if(scanner.hasNextInt()){
                int index = scanner.nextInt();
                if(index < AllPersons.getAllPersons().size()) {

                    //Add selected person to the list of travellers for the trip
                    Person toAdd = AllPersons.getAllPersons().get(index);
                    getTripContext().getTrip().getTravellers().add(toAdd);
                }else{
                    System.out.println("---Not an available traveller---");
                    continue;
                }
            }else if(scanner.hasNext()) {
                String answer = scanner.next();
                if(!continueEnteringTravellers(answer))
                    getTravellers = false;
                else if(returnLater(answer)){
                    return TripStateLoop.Status.Stop;
                }else{
                    System.out.println("---Not an available traveller---");
                    continue;
                }
            }
            else
                continue;
        }
        getTripContext().setTripState(new TripStateAddReservation(getTripContext()));
        return TripStateLoop.Status.Continue;
    }

    private Boolean continueEnteringTravellers(String answer){
        boolean done = answer.toLowerCase().equals("done");

        if(done && !getTripContext().getTrip().getTravellers().isEmpty()){
            System.out.println();
            System.out.println("*** TRAVELLERS FINISHED: " + getTripContext().getTrip().getTravellers().size() + " entered ***");
        }else
            done = false;

        return !done;
    }
}
