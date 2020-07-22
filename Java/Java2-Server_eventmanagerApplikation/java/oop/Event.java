package oop;


public class Event {
    //Default Private

    //Value
    private String eventName;
    private String eventOrt;
    private int piceOfVisibleCars;
    private int internEmployee;
    private int externEmployee;
    private int austeller;
    private int currentMaxUsablePlaces;

    //Geter
    public String getEventName(){return this.eventName;}
    public String getEventOrt(){return this.eventOrt;}
    public int getPiceOfVisibleCars(){return this.piceOfVisibleCars;}
    public int getInternEmployee(){return this.internEmployee;}
    public int getExternEmployee(){return this.externEmployee;}
    public int getCurrentEmployee(){return this.externEmployee + this.internEmployee;} //Gibt Gesamtanzahl an
    public int getAusteller(){return this.austeller;}
    public int getCurrentMaxUsablePlaces(){return this.currentMaxUsablePlaces;}

    //Seter
    public void setEventName(String newName){this.eventName = newName;}
    public void setEventOrt(String newOrt){this.eventOrt = newOrt;}
    public void setPiceOfVisibleCars(int newPiceOfVisibleCars){this.piceOfVisibleCars = newPiceOfVisibleCars;} //Funktion zur berechnung fehlt
    public void setInternEmployee(int newInternEmployee){this.internEmployee = newInternEmployee;}
    public void setExternEmployee(int newExternEmployee){this.externEmployee = newExternEmployee;}
    public void setAusteller(int newAusteller){this.austeller = newAusteller;}
    public void setCurrentMaxUsablePlaces(int newCurrentMaxUsablePlaces){this.currentMaxUsablePlaces = newCurrentMaxUsablePlaces;}

    //Funktion Logik

}
