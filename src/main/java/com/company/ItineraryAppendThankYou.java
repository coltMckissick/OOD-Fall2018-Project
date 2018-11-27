package com.company;

public class ItineraryAppendThankYou extends ItineraryDecorator {

    public ItineraryAppendThankYou(ItineraryComponent componentToDecorate) {
        super(componentToDecorate);
    }

    @Override
    public String output(){
        StringBuilder toOutput = new StringBuilder(super.output());
        toOutput.append(System.lineSeparator());
        toOutput.append(System.lineSeparator());
        toOutput.append(getTrip().getThankYou());
        return toOutput.toString();
    }
}
