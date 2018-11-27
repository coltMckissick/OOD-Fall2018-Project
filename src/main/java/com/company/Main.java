package com.company;

import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        //state loop will handle traversing through
        //the various states until the user
        //decides to return later (exit state loop with trip
        //in an incomplete state) OR the trip is complete.

        while (true){
            TripStateLoop tripStateLoop = new TripStateLoop();
            Trip trip;

            try {
                trip = tripStateLoop.execute();
            }catch(Exception ex){
                System.out.println(ex.getMessage());
                return;
            }

            showItinerary(trip);
        }

    }

    /// <summary>
    ///     Displays itinerary, if possible
    /// </summary>
    /// <param name="trip"></param>
    private static void showItinerary(Trip trip)
    {
        if (ItineraryFactory.TripCanProduceItinerary(trip))
        {
            System.out.println("Show itinerary? [yes]");
            if (!scanner.nextLine().toLowerCase().trim().equals("yes")) return;

            String itinerary;

            try{
                itinerary = ItineraryFactory.get(trip);
            }catch(Exception ex){
                System.out.println(ex.getMessage());
                return;
            }

            System.out.println(itinerary);
            return;
        }

        System.out.println("Trip " + trip.getID() + " is not complete - cannot produce itinerary yet");
        System.out.println("Trip " + trip.getID() + " state = " + trip.getStatus());
        System.out.println();
    }

}
