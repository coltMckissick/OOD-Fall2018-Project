package com.company;

import java.util.ArrayList;
import java.util.Date;

public class Trip {

    private int _id;
    private Date _bookedOn;
    private TravelAgent _travelAgent;
    private String _thankYou;
    private ArrayList<Person> _travellers;
    private ArrayList<Reservation> _reservations;
    private Bill _bill;
    private TripState.Status _status;
    private Itinerary itinerary;

    public Trip(){
        _travellers = new ArrayList<Person>();
        _reservations = new ArrayList<Reservation>();
        _bill = new Bill();
    }

    public Trip (int uniqueID, TravelAgent travelAgent){
        _travellers = new ArrayList<Person>();
        _reservations = new ArrayList<Reservation>();
        _bill = new Bill();
        _id = uniqueID;
        _travelAgent = travelAgent;
    }

    public TripState.Status getStatus(){
        return _status;
    }

    public void setTripStateStatus(TripState.Status Status) {
        _status = Status;
    }

    public int getID(){
        return _id;
    }

    public void setID(int id){
        _id = id;
    }

    public TravelAgent getTravelAgent(){
        return _travelAgent;
    }

    public void setTravelAgent(TravelAgent travelAgent){
        _travelAgent = travelAgent;
    }

    public String getThankYou(){
        return _thankYou;
    }

    public void setThankYou(String thankYou){
        _thankYou = thankYou;
    }

    public Date getBookedOn(){
        return _bookedOn;
    }

    public void setBookedOn(Date bookedOn){
        _bookedOn = _bookedOn;
    }

    public ArrayList<Person> getTravellers(){
        return _travellers;
    }

    public void setTravellers(ArrayList<Person> travellers){
        _travellers = travellers;
    }

    public ArrayList<Reservation> getReservations(){
        return _reservations;
    }

    public Bill getBill(){
        return _bill;
    }

    public void setBill(Bill bill){
        _bill = bill;
    }

}
