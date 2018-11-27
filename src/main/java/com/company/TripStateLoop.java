package com.company;


public class TripStateLoop {

    public Trip execute() throws Exception{
        return execute(null);
    }

    public Trip execute(Trip trip) throws Exception
    {

        TripContext tripContext = trip == null
                ? new TripContext()
                : new TripContext(trip);

        while (tripContext.execute() == Status.Continue)
        {
            //keep looping while the states are saying continue
        }

        System.out.println(System.lineSeparator());
        System.out.println("*** TripStateLoop.Status.Stopped ***");
        System.out.println(System.lineSeparator());

        return tripContext.getTrip();
    }

    public enum Status{
        Continue,
        Stop
    }

}
