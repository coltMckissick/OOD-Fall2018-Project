package com.company;

import java.math.BigDecimal;

public class Package {

    private BigDecimal _price;
    private double _hoursOfTravel;
    private Place _start;
    private Place _end;
    private Transport _transport;

    public Package(Place start, Place end, Transport transport, double hoursOfTravel){
        _start = start;
        _end = end;
        _transport = transport;
        _hoursOfTravel = hoursOfTravel;
        _price = transport.getPricePerHour().multiply(new BigDecimal(hoursOfTravel));
    }

    public Place getStart(){
        return _start;
    }

    public void setStart(Place start){
        _start = start;
    }

    public Place getEnd(){
        return _end;
    }

    public void setEnd(Place end){
        _end = end;
    }

    public Transport getTransport(){
        return _transport;
    }

    public void setTransport(Transport transport){
        _transport = transport;
    }

    public BigDecimal getPrice(){
        return _price;
    }

    public void setPrice(BigDecimal price){
        _price = price;
    }

    public double getHoursOfTravel(){
        return _hoursOfTravel;
    }

    @Override
    public String toString(){
        return "Start: " + _start.getName() + ", End: " + _end.getName() + "\n"
                + "Transport Type: " + _transport.getType() + ", Hours of Travel: " + _hoursOfTravel
                + ", Price: " + _price;
    }

}
