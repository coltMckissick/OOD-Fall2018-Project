package com.company;

import java.util.ArrayList;

public class ItineraryAppendReservations extends ItineraryDecorator {

    public ItineraryAppendReservations(ItineraryComponent componentToDecorate) {
        super(componentToDecorate);
    }

    @Override
    public String output(){

        StringBuilder toOutput = new StringBuilder(super.output());
        ArrayList<Reservation> reservations = getTrip().getReservations();

        toOutput.append(System.lineSeparator());
        toOutput.append(System.lineSeparator());
        toOutput.append("Reservations: ");

        for (Reservation reservation:
             reservations) {
            toOutput.append(System.lineSeparator());
            toOutput.append(reservation.toString());
        }

        return toOutput.toString();

    }
}
