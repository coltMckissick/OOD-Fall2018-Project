package com.company;

import java.util.Date;

public class TripStateComplete extends TripState {
    public TripStateComplete(TripContext tripContext) {
        super(tripContext, Status.Complete);
    }

    @Override
    public TripStateLoop.Status execute() {

        getTripContext().getTrip().setBookedOn(new Date());

        return TripStateLoop.Status.Stop;
    }
}
