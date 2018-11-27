package com.company;

public class TripContextStateFactory {

    public static TripState get(TripState.Status tripStateStatus, TripContext context) throws Exception
    {
        //Kind of a work around, I use this to continue a saved state

        switch (tripStateStatus)
        {
            case Create:
                return new TripStateCreate(context);

            case AddTraveller:
                return new TripStateAddTraveller(context);

            case AddReservation:
                return new TripStateAddReservation(context);

            case ChoosePaymentType:
                return new TripStateChoosePaymentType(context);

            case PayCash:
                return new TripStatePayCash(context);

            case PayCheck:
                return new TripStatePayCheck(context);

            case PayCredit:
                return new TripStatePayCredit(context);

            case AddThankYou:
                return new TripStateAddThankYou(context);

            case Complete:
                return new TripStateComplete(context);

            default:
                throw new Exception(tripStateStatus + " is an invalid state");
        }
    }

    public static TripState get(TripContext context) throws Exception
    {
        assert context != null;
        assert context.getTrip() != null;

        TripState.Status tripStateStatus = context.getTrip().getStatus();

        switch (tripStateStatus)
        {
            case Create:
                return new TripStateCreate(context);

            case AddTraveller:
                return new TripStateAddTraveller(context);

            case AddReservation:
                return new TripStateAddReservation(context);

            case ChoosePaymentType:
                return new TripStateChoosePaymentType(context);

            case PayCash:
                return new TripStatePayCash(context);

            case PayCheck:
                return new TripStatePayCheck(context);

            case PayCredit:
                return new TripStatePayCredit(context);

            case AddThankYou:
                return new TripStateAddThankYou(context);

            case Complete:
                return new TripStateComplete(context);

            default:
                throw new Exception(tripStateStatus + " is an invalid state");
        }
    }

}
