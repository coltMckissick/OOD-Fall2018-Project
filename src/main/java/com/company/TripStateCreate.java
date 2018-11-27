package com.company;

import java.util.Date;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class TripStateCreate extends TripState {

    public TripStateCreate(TripContext context){
        super(context, Status.Create);

        Trip trip = new Trip();

        trip.setID(new Random().nextInt(1000));
        //trip.setTravelAgent(travelAgent);

        trip.setTripStateStatus(Status.Create);

        getTripContext().setTrip(trip);
    }

    @Override
    public TripStateLoop.Status execute() {
        System.out.println();

        Boolean getTravelAgent = true;
        while(getTravelAgent) {
            Scanner scanner = new Scanner(System.in);

            //Load & Display all travel agents from the AllTravelAgents singleton

            System.out.println("---Available TravelAgents---");//UI selectable list later
            for (int i = 0; i < AllTravelAgents.getAllTravelAgents().size(); i++) {
                System.out.println(i + ": " + AllTravelAgents.getAllTravelAgents().get(i).toString());
            }
            System.out.println("Select your travel agent account: ");
            if (scanner.hasNextInt()) {
                int index = scanner.nextInt();
                if (index < AllTravelAgents.getAllTravelAgents().size()) {
                    TravelAgent travelAgent = AllTravelAgents.getAllTravelAgents().get(index); //select your account

                    //check if any owned trips, if not create new trip
                    if(!travelAgent.getOwnedTrips().isEmpty()) {
                        Boolean selectPastTrips = true;
                        while (selectPastTrips) {

                            //list owned trips
                            System.out.println("---Owned Trips---");
                            HashMap<Integer, Trip> tempTripMap = travelAgent.getOwnedTrips();
                            for (Integer id :
                                    tempTripMap.keySet()) {
                                System.out.println(id + " Status: " + tempTripMap.get(id).getStatus());
                            }
                            System.out.println("Would you like to continue or start a [new] trip? ");
                            String answer = scanner.next().trim();
                            if(answer.equals("new")) {
                                selectPastTrips = false;
                            }
                            else if(answer.equals("continue")){

                                //Select past trip
                                System.out.println("Enter the number of the trip you would like to continue: ");
                                if(scanner.hasNextInt()){
                                    int tripKey = scanner.nextInt();
                                    Trip continuedTrip = tempTripMap.get(tripKey);
                                    getTripContext().setTrip(continuedTrip);
                                    try {
                                        //Load past trip
                                        getTripContext().setTripState(TripContextStateFactory.
                                                get(continuedTrip.getStatus(), getTripContext()));
                                    }catch(Exception e){System.out.println(e.getMessage());}
                                    return TripStateLoop.Status.Continue;
                                }

                            }
                        }
                    }

                    travelAgent.getOwnedTrips().put(getTripContext().getTrip().getID(),
                            getTripContext().getTrip());
                    getTripContext().getTrip().setTravelAgent(travelAgent);

                    getTravelAgent = false;
                } else {
                    System.out.println("---Not an available travel agent---");
                    continue;
                }
            }
        }

        getTripContext().setTripState(new TripStateAddTraveller(getTripContext()));

        return TripStateLoop.Status.Continue;
    }

}
