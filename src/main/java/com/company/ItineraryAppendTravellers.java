package com.company;

import java.util.ArrayList;

public class ItineraryAppendTravellers extends ItineraryDecorator {

    public ItineraryAppendTravellers(ItineraryComponent itineraryComponent){
        super(itineraryComponent);
    }

    @Override
    public String output(){

        StringBuilder toOutput = new StringBuilder(super.output());
        ArrayList<Person> travellers = getTrip().getTravellers();

        toOutput.append(System.lineSeparator());
        toOutput.append(System.lineSeparator());
        toOutput.append("Travellers: ");

        for (Person person:
             travellers) {
            toOutput.append(System.lineSeparator());
            toOutput.append(person.toString());
        }

        return toOutput.toString();
    }

}
