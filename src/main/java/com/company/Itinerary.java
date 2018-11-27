package com.company;

public class Itinerary implements ItineraryComponent{

    private Trip _trip;

    public Itinerary(Trip trip){
        _trip = trip;
    }

    @Override
    public Trip getTrip() {
        return _trip;
    }

    @Override
    public String output() {
        return new String();
    }
}
