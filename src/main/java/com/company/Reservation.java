package com.company;

import java.util.Calendar;
import java.util.Date;

public class Reservation {

    private Date _departOn;
    private Date _arriveOn;
    private Package _package;

    public Reservation(Date departOn, Package packageToReserve){
        _departOn = departOn;
        _package = packageToReserve;

        Calendar tempCalendar = Calendar.getInstance();
        tempCalendar.setTime(departOn);
        tempCalendar.add(Calendar.HOUR, (int)packageToReserve.getHoursOfTravel());

        _arriveOn = tempCalendar.getTime();
    }

    public Package getPackage(){
        return _package;
    }

    public void setPackage(Package packageToReserve){
        _package = packageToReserve;
    }

    public Date getDepartOn(){
        return _departOn;
    }

    public void setDepartOn(Date departOn){
        _departOn = departOn;
    }

    public Date getArriveOn(){
        return _arriveOn;
    }

    public void setArriveOn(Date arriveOn){
        _arriveOn = arriveOn;
    }

    @Override
    public String toString(){
        return "Departing: " + _departOn + " Arriving: " + _arriveOn + "\n" + _package.toString();
    }
}
