package com.company;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public abstract class TripState {

    private TripContext _tripContext;

    protected TripState(TripContext tripContext, Status tripStateStatus){
        _tripContext = tripContext;

        if(_tripContext.getTrip() != null)
            _tripContext.getTrip().setTripStateStatus(tripStateStatus);
    }

    public TripContext getTripContext(){
        return _tripContext;
    }

    public void setTripContext(TripContext tripContext){
        _tripContext = tripContext;
    }

    public abstract TripStateLoop.Status execute();

    protected boolean returnLater(String answer){
        boolean returnLater = answer.toLowerCase().equals("later");

        if(returnLater){
            System.out.println();
            System.out.println("*** RETURN LATER TO FINISH ***");
        }

        return returnLater;
    }


    public enum Status
    {
        Create,
        AddTraveller,
        AddReservation,
        ChoosePaymentType,
        PayCash,
        PayCheck,
        PayCredit,
        AddThankYou,
        Complete
    }

}
