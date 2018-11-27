package com.company;

public abstract class ItineraryDecorator implements ItineraryComponent{

    private final ItineraryComponent _componentToDecorate;

    protected ItineraryDecorator(ItineraryComponent componentToDecorate){
        _componentToDecorate = componentToDecorate;
    }

    @Override
    public Trip getTrip() {
        return _componentToDecorate.getTrip();
    }

    @Override
    public String output() {
        return _componentToDecorate.output();
    }

}
