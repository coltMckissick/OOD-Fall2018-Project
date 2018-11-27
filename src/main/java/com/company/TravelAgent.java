package com.company;

import java.util.HashMap;

public class TravelAgent extends Person {

    private int _agentID;

    private HashMap<Integer,Trip> _ownedTrips;

    public TravelAgent(String name, int phoneNumber, int agentID){
        super(name, phoneNumber);
        _agentID = agentID;
        _ownedTrips = new HashMap<>();
    }

    @Override
    public String toString(){
        return "Agent ID: " + _agentID + ", Name: " + super.getName() + ", Phone Number: " + super.getPhoneNumber();
    }

    public HashMap<Integer,Trip> getOwnedTrips(){
        return _ownedTrips;
    }

    public void setOwnedTrips(HashMap<Integer,Trip> ownedTrips){
        _ownedTrips = ownedTrips;
    }
}
