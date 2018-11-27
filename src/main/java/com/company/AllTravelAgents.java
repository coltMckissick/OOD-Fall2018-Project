package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AllTravelAgents {

    private static final Object syncLock = new Object();
    private static volatile AllTravelAgents _allTravelAgents;

    private List<TravelAgent> allTravelAgentsList;

    private AllTravelAgents(){
        ArrayList<TravelAgent> tempTravelAgentList = new ArrayList<TravelAgent>();
        tempTravelAgentList.add(new TravelAgent("Timothy", 123456789, 001));
        tempTravelAgentList.add(new TravelAgent("Reggie", 123456789, 002));
        tempTravelAgentList.add(new TravelAgent("John", 123456789, 003));
        tempTravelAgentList.add(new TravelAgent("Kim", 123456789, 004));
        tempTravelAgentList.add(new TravelAgent("Sam", 123456789, 005));
        tempTravelAgentList.add(new TravelAgent("William", 123456789, 006));
        tempTravelAgentList.add(new TravelAgent("Bond, James Bond", 111111007, 007));
        allTravelAgentsList = Collections.unmodifiableList(tempTravelAgentList);
    }

    public static List<TravelAgent> getAllTravelAgents()
    {
        //double checking lazy load singleton
        if (_allTravelAgents == null) {
            synchronized (syncLock) { //thread-safe
                if (_allTravelAgents == null) { _allTravelAgents = new AllTravelAgents();	}
            }
        }

        return _allTravelAgents.allTravelAgentsList;
    }

}
