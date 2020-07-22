package oop;

import oop.Color;

public class Car implements Comparable<Car>{
    //CompareTo
    public int compareTo(Car other){
        return this.getModellType().compareTo(other.getModellType());
    }


    //Value
    private String modellType;
    private int piceOfModell;
    private int piceHolder;
    private Color carColor;
    private String admissionYear;
    private String constructionYear;
    private int currentKmH;
    private int PS;
    private int maxSpeed;
    private int maxSitPlaces;
    //private int currentDoors; // 5 Türer oder 3 Türer über enum ?

    //Geter
    public String getModellType(){return this.modellType;}
    public int getPiceOfModell(){return this.piceOfModell;}
    public int getHolder(){return this.piceHolder;}
    public String getAdmissionYear(){return this.admissionYear;}
    public String getConstructionYear(){return this.constructionYear;}
    public int getCurrentKmH(){return this.currentKmH;}
    public int getPS(){return this.PS;}
    public int getMaxSpeed(){return this.maxSpeed;}
    public int getMaxSitPlaces(){return this.maxSitPlaces;}
    public Color getCarColor(){return this.carColor;}

    //Seter
    public void setModellType(String newModellType){this.modellType = newModellType;}
    public void setPiceOfModell(int newPiceOfModell){this.piceOfModell = newPiceOfModell;}
    public void setHolder(int newHolder){this.piceHolder = newHolder;}
    public void setAdmissionYear(String newAdmissionYear){this.admissionYear = newAdmissionYear;}
    public void setConstructionYear(String newConstructionYear){this.constructionYear = newConstructionYear;}
    public void setCurrentKmH(int newCurrentKmh){this.currentKmH = newCurrentKmh;}
    public void setPS(int newPS){this.PS = newPS;}
    public void setMaxSpeed(int newMaxSpeed){this.maxSpeed = newMaxSpeed;}
    public void setMaxSitPlaces(int newMaxSitPlaces){this.maxSitPlaces = newMaxSitPlaces;}
    public void setCarColor(Color newCarColor){this.carColor = newCarColor;}


    //Für die ausgabe dieses Objectes
    @Override
    public String toString() {
        return getModellType();
    }


}