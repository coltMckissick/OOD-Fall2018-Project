package com.company;

public class ItineraryAppendTravelAgentInfo extends ItineraryDecorator {

    public ItineraryAppendTravelAgentInfo(ItineraryComponent componentToDecorate) {
        super(componentToDecorate);
    }

    @Override
    public String output(){

        StringBuilder toOutput = new StringBuilder(super.output());

        TravelAgent agent = getTrip().getTravelAgent();

        toOutput.append(System.lineSeparator());
        toOutput.append(System.lineSeparator());
        toOutput.append(agent.toString());

        return toOutput.toString();

    }
}
