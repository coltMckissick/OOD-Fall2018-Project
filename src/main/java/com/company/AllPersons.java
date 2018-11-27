package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AllPersons {

    private static final Object syncLock = new Object();
    private static volatile AllPersons _allPersons;

    private List<Person> allPersonsList;

    private AllPersons(){
        ArrayList<Person> tempPersonList = new ArrayList<Person>();

        tempPersonList.add(new Person("Poe Pickles", 789483748));
        tempPersonList.add(new Person("Poe Pickles' friend", 918302921));
        tempPersonList.add(new Person("Steve", 1232456789));
        tempPersonList.add(new Person("Bob", 1234526789));
        tempPersonList.add(new Person("Richard", 1234546789));
        allPersonsList = Collections.unmodifiableList(tempPersonList);
    }

    public static List<Person> getAllPersons()
    {
        //double checking lazy load singleton
        if (_allPersons == null) {
            synchronized (syncLock) { //thread-safe
                if (_allPersons == null) { _allPersons = new AllPersons();	}
            }
        }

        return _allPersons.allPersonsList;
    }

}
