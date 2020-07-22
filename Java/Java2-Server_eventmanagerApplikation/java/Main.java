import oop.Color;
import oop.Event;
import oop.Car;
import oop.CarController;
import db.Database;

import java.util.List;


public class Main {

    public static void createTestDatas(String name, String ort, int austeller, int
            piceOfVisibleCars, int currentPlace, int internEmployee, int externEmployee)
    {
        Event event = new Event();
        event.setEventName(name);
        event.setEventOrt(ort);
        event.setAusteller(austeller);
        event.setPiceOfVisibleCars(piceOfVisibleCars);
        event.setCurrentMaxUsablePlaces(currentPlace);
        event.setInternEmployee(internEmployee);
        event.setExternEmployee(externEmployee);
    }

    public static void main(String[] args){

        //JAVA 1 Verbesserung
        //Test Daten zum erstellen von Events
        createTestDatas("Audi Convention","Erfurt",37,74,132,29,57);
        createTestDatas("Bmw Must Have","Muenchen",19,74,100,13,73);
        createTestDatas("VW Für JEDEN","Berlin",57,106,148,39,109);



        //Event erstellen
        //Event myEvent = new Event();

        //Deklarieren
        //myEvent.setEventName("Mein erstes Event");
        //myEvent.setEventOrt("Erfurt");
        //myEvent.setAusteller(38);
        //myEvent.setCurrentMaxUsablePlaces(139);
        //myEvent.setPiceOfVisibleCars(38);
        //myEvent.setInternEmployee(3);
        //myEvent.setExternEmployee(8);


        //Ausgabe
        //System.out.println(myEvent.getEventName());
        //System.out.println(myEvent.getEventOrt());
        //System.out.println(myEvent.getAusteller()) ;
        //System.out.println(myEvent.getPiceOfVisibleCars());
        //System.out.println(myEvent.getInternEmployee());
        //System.out.println(myEvent.getExternEmployee());
        //System.out.println(myEvent.getCurrentEmployee());
        //System.out.println(myEvent.getCurrentMaxUsablePlaces());


        //Auto und Autofarbe Deklarieren und Liste auslesen
        //Car car1 = new Car();
        //car1.setCarColor(Color.BLACK);
        //Car car2 = new Car();
        //car2.setCarColor(Color.BLUE);
        //Ausgabe
        //System.out.println(car1.getCarColor());
        //CarController cControler = new CarController();

        //Datenbank ausgabe
        //Database.db_Handler();


        //Testausgabe von CarController

        CarController carC = new CarController();

        for(int index = 0; index < 10 ; ++index){
            Car car =  new Car();

            switch (index){
                case 3:
                    car.setModellType("A1");
                    car.setConstructionYear("01.09.2019");
                    car.setCarColor(Color.BLACK);
                    car.setHolder(index);
                    car.setPS(89);
                    car.setMaxSpeed(110);
                    carC.addElementToList(car);
                    break;
                case 7:
                    car.setModellType("A5");
                    car.setConstructionYear("01.09.2019");
                    car.setCarColor(Color.BLACK);
                    car.setHolder(index);
                    car.setPS(169);
                    car.setMaxSpeed(110);
                    carC.addElementToList(car);
                    break;
                default:
                    car.setModellType("A8");
                    car.setConstructionYear("01.09.2019");
                    car.setCarColor(Color.BLACK);
                    car.setHolder(index);
                    car.setPS(69);
                    car.setMaxSpeed(110);
                    carC.addElementToList(car);
                    break;
            }
        }


        //Sotieren der Liste
        //Standart Sotierung
        carC.sortList();
        System.out.println(carC.carOutPut());
        //sort Higher Ps
        carC.sortPsLowerToUper();
        System.out.println(carC.carOutPut());
        //sort Lower Ps
        carC.sortPsUperToLower();
        System.out.println(carC.carOutPut());



    }
}
