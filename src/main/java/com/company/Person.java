package com.company;

public class Person {

    private String _name;
    private int _phoneNumber;

    protected Person(String name, int phoneNumber){
        _name = name;
        _phoneNumber = phoneNumber;
    }

    public String getName(){
        return _name;
    }

    public int getPhoneNumber(){
        return _phoneNumber;
    }

    @Override
    public String toString(){
        return "Name: " +  _name + " Phone Number: " + _phoneNumber;
    }

}
