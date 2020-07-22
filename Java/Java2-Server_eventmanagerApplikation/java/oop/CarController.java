package oop;

import oop.util.*;

import java.util.*;
import java.util.List;



public class CarController{
    private List<Car> carList;

    //Konstruktor inialisierung
    public CarController(){
        this.carList = new ArrayList<>();
    }

    //Ist nötig um auto object zurück zu geben
    public Car getCar(int index)
    {
        return this.carList.get( index );
    }


    //element zur liste hinzufügen
    public void addElementToList(Car car){
        this.carList.add(car);
    }

    //Löscht das letze Element einer liste+
    //-1 da der index bei 0 anfängt
    public void deleteElementFromList(){
        if(carList.size() > 0) {
            this.carList.remove(this.carList.size()-1);
        }
    }

    //prüfen ob liste leer ist
    public boolean isTheListEmpty(){
       if(carList.size() > 0){
            return true;
       }
       else{
           return false;
       }
    }

    //##############################################################################################
    //Sotieren von Listen nach Bestimten Vorraussetzungen
    //Standart Sotieren der Liste
    public void sortList(){
        Collections.sort(carList);
    }

    public void sortPsLowerToUper(){
        Collections.sort(carList, new CarPsLowerToUperComparator());
    }

    public void sortPsUperToLower(){
        Collections.sort(carList, new CarPsUperToLowerComparator());
    }

    public void sortCurrentKmHUperToLower(){
        Collections.sort(carList, new CarUperToLowerKmHComparator());
    }

    public void sortCurrentKmHLowerToUper(){
        Collections.sort(carList, new CarLowerToUperKmHComparator());
    }

    public void sortHolderLowerToUper(){
        Collections.sort(carList, new CarLowerToUperHolderComparator());
    }

    public void sortHolderUperToLower(){
        Collections.sort(carList, new CarUperToLowerHolderComparator());
    }

    public void sortMaxSpeedLowerToUper(){
        Collections.sort(carList, new CarLowerToUperSpeedComparator());
    }

    public void sortMaxSpeedUperToLower(){
        Collections.sort(carList, new CarUperToLowerSpeedComparator());
    }

    public void sortMaxSitPlaceLowerToUper(){
        Collections.sort(carList, new CarLowerToUperSizPlaceComparator());
    }
    public void sortMaxSitPlaceUperToLower(){
        Collections.sort(carList, new CarUperToLowerSitPlaceComparator());
    }
    //Sotierungen ENDE
    //##############################################################################################

    public String carOutPut(){
        //Bessere Lösung, um Speicher zu sparen und keine Kopien anzulegen
        StringBuilder result = new StringBuilder();


        //String output = "";
        for(int index = 0; index < carList.size(); ++index){
            result.append(carList.get(index).getModellType() + " ");
        }
        return result.toString();
    }

    //Laenge der Liste zurückgeben
    public int getSize()
    {
        return this.carList.size();
    }


}