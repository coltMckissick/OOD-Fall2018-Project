package com.company;

public class TripContext {

    private Trip _trip;
    private TripState _tripState;

    public TripContext(){
        _tripState = new TripStateCreate(this);
    }

    public TripContext(Trip trip) throws Exception{
        assert trip != null : "trip cannot be null";

        _trip = trip;
        _tripState = TripContextStateFactory.get(this);
    }

    public Trip getTrip(){
        return _trip;
    }

    public void setTrip(Trip trip){
        _trip = trip;
    }

    public TripState getTripState(){
        return _tripState;
    }

    public void setTripState(TripState tripState){
        _tripState = tripState;
    }

    public TripStateLoop.Status execute() {
        return _tripState.execute();
    }
}
