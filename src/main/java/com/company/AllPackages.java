package com.company;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AllPackages {

    private static final Object syncLock = new Object();
    private static volatile AllPackages _allPackages;

    private List<Package> allPackagesList;

    private AllPackages(){
        ArrayList<Package> tempPackageList = new ArrayList<Package>();

        tempPackageList.add(new Package(new Place("atlanta"), new Place("new orleans"),
                new Transport(Transport.Type.Limo, new BigDecimal(1000)), 15));

        tempPackageList.add(new Package(new Place("new orleans"), new Place("san antonio"),
                new Transport(Transport.Type.Helicopter, new BigDecimal(2000)), 8));

        tempPackageList.add(new Package(new Place("san antonio"), new Place("san francisco"),
                new Transport(Transport.Type.PrivateJet, new BigDecimal(10000)), 4));

        tempPackageList.add(new Package(new Place("san francisco"), new Place("tokyo"),
                new Transport(Transport.Type.PrivateJet, new BigDecimal(10000)), 10));

        tempPackageList.add(new Package(new Place("tokyo"), new Place("sydney"),
                new Transport(Transport.Type.PrivateJet, new BigDecimal(10000)), 5));

        tempPackageList.add(new Package(new Place("sydney"), new Place("wellington"),
                new Transport(Transport.Type.Yacht, new BigDecimal(25000)), 15));

        tempPackageList.add(new Package(new Place("wellington"), new Place("hobbiton"),
                new Transport(Transport.Type.Limo, new BigDecimal(1000)), 10));

        allPackagesList = Collections.unmodifiableList(tempPackageList);
    }

    public static List<Package> getAllPackages()
    {
        //double checking lazy load singleton
        if (_allPackages == null) {
            synchronized (syncLock) { //thread-safe
                if (_allPackages == null) { _allPackages = new AllPackages();	}
            }
        }

        return _allPackages.allPackagesList;
    }

}
