package com.company;

public class ItineraryFactory {

    public static String get(Trip trip){

        ItineraryComponent itinerary = new Itinerary(trip);
        itinerary = new ItineraryAppendTravelAgentInfo(itinerary);
        itinerary = new ItineraryAppendTravellers(itinerary);
        itinerary = new ItineraryAppendReservations(itinerary);
        itinerary = new ItineraryAppendBill(itinerary);
        itinerary = new ItineraryAppendThankYou(itinerary);

        return itinerary.output();

    }

    //Used to verify the factory will produce an itinerary.
    //If not checked prior to calling factory, exception can occur.
    public static boolean TripCanProduceItinerary(Trip trip){
        //!!!!THIS IS NOT EXACTLY THE SAME AS C#!!!!!!!!
        //there is no 'nameof' operator in Java. if there is time
        //I might search for 3rd party library
        assert trip != null : "trip != null";

        return trip.getStatus() == TripState.Status.Complete;
    }

    public static void ValidateTripCanProduceItinerary(Trip trip) throws Exception{
        //!!!!THIS IS NOT EXACTLY THE SAME AS C#!!!!!!!!
        //there is no 'nameof' operator in Java. if there is time
        //I might search for 3rd party library
        assert trip != null : "trip != null";

        if(!TripCanProduceItinerary(trip))
            throw new Exception("trip must be in complete state to generate itinerary. currently in " + trip.getStatus());
    }

}
