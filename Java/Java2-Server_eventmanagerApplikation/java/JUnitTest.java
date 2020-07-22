import oop.CarController;
import oop.Color;
import org.junit.Test;
import oop.Car;
import oop.Event;

import static junit.framework.TestCase.assertEquals;

public class JUnitTest {

    Car car = new Car();

    //############################################################################
    //Car Klasse Testen
    //############################################################################
    @Test
    public void isCreateCarModellType(){
        car.setModellType("audi a8");
        assertEquals("audi a8", car.getModellType());
    }

    @Test
    public void isCreateCarPiceOfModell(){
        car.setPiceOfModell(35);
        assertEquals(35,car.getPiceOfModell());
    }

    @Test
    public void isCreateCarPiceHolder(){
        car.setHolder(2);
        assertEquals(2,car.getHolder());
    }

    @Test
    public void isCreateCarColor(){
        car.setCarColor(Color.BLUE);
        assertEquals(Color.BLUE, car.getCarColor());
    }

    @Test
    public void isCreateCarAdmissionYear(){
        car.setAdmissionYear("01.08.2019");
        assertEquals("01.08.2019",car.getAdmissionYear());
    }

    @Test
    public void isCreateCarCinstructionYear(){
        car.setConstructionYear("09.07.2018");
        assertEquals("09.07.2018", car.getConstructionYear());
    }

    @Test
    public void isCreateCarCurrentKmH(){
        car.setCurrentKmH(85000);
        assertEquals(85000, car.getCurrentKmH());
    }

    @Test
    public void isCreateCarPS(){
        car.setPS(130);
        assertEquals(130,car.getPS());
    }

    @Test
    public void isCreateCarMaxSpeed(){
        car.setMaxSpeed(190);
        assertEquals(190, car.getMaxSpeed());
    }

    @Test
    public void isCreateCarmaxSitPlaces(){
        car.setMaxSitPlaces(6);
        assertEquals(6,car.getMaxSitPlaces());
    }
    //############################################################################



    //############################################################################
    //Event
    //############################################################################
    Event event = new Event();

    @Test
    public void isCreateEventName(){
        event.setEventName("First Event");
        assertEquals("First Event", event.getEventName());
    }

    @Test
    public void isCreateEventOrt(){
        event.setEventOrt("Erfurt");
        assertEquals("Erfurt", event.getEventOrt());
    }

    @Test
    public void isCreateEventPiceOfVisiblecars(){
        event.setPiceOfVisibleCars(130);
        assertEquals(130, event.getPiceOfVisibleCars());
    }

    @Test
    public void isCreateEventInternEmployee(){
        event.setInternEmployee(37);
        assertEquals(37,event.getInternEmployee());
    }

    @Test
    public void isCreateEventExternEmployee(){
        event.setExternEmployee(89);
        assertEquals(89,event.getExternEmployee());
    }

    @Test
    public void isCreateEventCurrentEmployee(){
        event.setExternEmployee(36);
        event.setInternEmployee(45);
        assertEquals(81, event.getCurrentEmployee());
    }

    @Test
    public void isCreateEventAusteller(){
        event.setAusteller(54);
        assertEquals(54, event.getAusteller());
    }

    @Test
    public void isCreateEventCurrentMaxUsablePlaces(){
        event.setCurrentMaxUsablePlaces(189);
        assertEquals(189,event.getCurrentMaxUsablePlaces());
    }

    //############################################################################

    //############################################################################
    //CarControler
    //############################################################################
    CarController carC = new CarController();

    Car car2 = new Car();

    public Car fillCar(){
        car2.setCarColor(Color.GREEN);
        car2.setMaxSitPlaces(3);
        car2.setMaxSpeed(110);
        car2.setPS(139);
        car2.setCurrentKmH(79000);
        car2.setConstructionYear("19.08.2016");
        car2.setHolder(3);
        return car2;
    }

    @Test
    public void canDeletElement(){
        int x = 1;
        carC.addElementToList(fillCar());
        int currentSizeAfterDelet = carC.getSize() - x;
        carC.deleteElementFromList();
        assertEquals(currentSizeAfterDelet,carC.getSize());
    }

    @Test
    public void canAddElement(){
        int afterAdd = carC.getSize() +1;
        carC.addElementToList(fillCar());
        assertEquals(afterAdd,carC.getSize());
    }

    @Test
    public void isListEmpty(){
        assertEquals(false,carC.isTheListEmpty());
    }

    @Test
    public void isListAfterDeletEmpty(){
        carC.addElementToList(fillCar());
        carC.deleteElementFromList();
        assertEquals(false,carC.isTheListEmpty());
    }

    @Test
    public void isSizeCorrect(){
        int currentSize = 0;
        carC.addElementToList(fillCar());
        currentSize +=1;
        carC.deleteElementFromList();
        currentSize -= 1;
        assertEquals(currentSize,carC.getSize());
    }

    @Test
    public void canGetCar(){
        Car car3 = new Car();
        car3 = fillCar();
        carC.addElementToList(car3);
        assertEquals(car3,carC.getCar(carC.getSize()-1));
    }

    @Test
    public void sortListFromModellType(){
        Car car4 = new Car();
        car4.setModellType("A5");
        Car car5 = new Car();
        car5.setModellType("A8");
        Car car6 = new Car();
        car6.setModellType("A1");
        //List ADD
        carC.addElementToList(car4);
        carC.addElementToList(car5);
        carC.addElementToList(car6);
        //Sortiert Liste
        carC.sortList();


        assertEquals(carC.getCar(0).getModellType(),"A1");
        assertEquals(carC.getCar(1).getModellType(),"A5");
        assertEquals(carC.getCar(2).getModellType(),"A8");
    }

    @Test
    public void sortListSpezifyTypes(){
        Car c10 = new Car();
        Car c11 = new Car();
        Car c12 = new Car();
        Car c13 = new Car();
        Car c14 = new Car();
        Car c15 = new Car();

        c10.setModellType("C10");
        c10.setMaxSitPlaces(9);
        c10.setMaxSpeed(110);
        c10.setPS(139);
        c10.setCurrentKmH(81000);
        c10.setHolder(3);

        c11.setModellType("C11");
        c11.setMaxSitPlaces(5);
        c11.setMaxSpeed(168);
        c11.setPS(169);
        c11.setCurrentKmH(139000);
        c11.setHolder(2);

        c12.setModellType("C12");
        c12.setMaxSitPlaces(2);
        c12.setMaxSpeed(210);
        c12.setPS(184);
        c12.setCurrentKmH(259000);
        c12.setHolder(10);

        c13.setModellType("C13");
        c13.setMaxSitPlaces(8);
        c13.setMaxSpeed(160);
        c13.setPS(101);
        c13.setCurrentKmH(490000);
        c13.setHolder(7);

        c14.setModellType("C14");
        c14.setMaxSitPlaces(3);
        c14.setMaxSpeed(109);
        c14.setPS(139);
        c14.setCurrentKmH(79000);
        c14.setHolder(9);

        c15.setModellType("C15");
        c15.setMaxSitPlaces(4);
        c15.setMaxSpeed(180);
        c15.setPS(98);
        c15.setCurrentKmH(39000);
        c15.setHolder(1);

        carC.addElementToList(c10);
        carC.addElementToList(c11);
        carC.addElementToList(c12);
        carC.addElementToList(c13);
        carC.addElementToList(c14);
        carC.addElementToList(c15);

        //KmH Sort
        carC.sortCurrentKmHLowerToUper();
        assertEquals(carC.getCar(0).getModellType(), "C15");
        assertEquals(carC.getCar(1).getModellType(), "C14");
        assertEquals(carC.getCar(2).getModellType(), "C10");
        assertEquals(carC.getCar(3).getModellType(), "C11");
        assertEquals(carC.getCar(4).getModellType(), "C12");
        assertEquals(carC.getCar(5).getModellType(), "C13");

        carC.sortCurrentKmHUperToLower();
        assertEquals(carC.getCar(0).getModellType(), "C13");
        assertEquals(carC.getCar(1).getModellType(), "C12");
        assertEquals(carC.getCar(2).getModellType(), "C11");
        assertEquals(carC.getCar(3).getModellType(), "C10");
        assertEquals(carC.getCar(4).getModellType(), "C14");
        assertEquals(carC.getCar(5).getModellType(), "C15");

        //Holder Sort
        carC.sortHolderLowerToUper();
        assertEquals(carC.getCar(0).getModellType(), "C15");
        assertEquals(carC.getCar(1).getModellType(), "C11");
        assertEquals(carC.getCar(2).getModellType(), "C10");
        assertEquals(carC.getCar(3).getModellType(), "C13");
        assertEquals(carC.getCar(4).getModellType(), "C14");
        assertEquals(carC.getCar(5).getModellType(), "C12");

        carC.sortHolderUperToLower();
        assertEquals(carC.getCar(0).getModellType(), "C12");
        assertEquals(carC.getCar(1).getModellType(), "C14");
        assertEquals(carC.getCar(2).getModellType(), "C13");
        assertEquals(carC.getCar(3).getModellType(), "C10");
        assertEquals(carC.getCar(4).getModellType(), "C11");
        assertEquals(carC.getCar(5).getModellType(), "C15");

        //Speed Sort
        carC.sortMaxSpeedLowerToUper();
        assertEquals(carC.getCar(0).getModellType(), "C14");
        assertEquals(carC.getCar(1).getModellType(), "C10");
        assertEquals(carC.getCar(2).getModellType(), "C13");
        assertEquals(carC.getCar(3).getModellType(), "C11");
        assertEquals(carC.getCar(4).getModellType(), "C15");
        assertEquals(carC.getCar(5).getModellType(), "C12");

        carC.sortMaxSpeedUperToLower();
        assertEquals(carC.getCar(0).getModellType(), "C12");
        assertEquals(carC.getCar(1).getModellType(), "C15");
        assertEquals(carC.getCar(2).getModellType(), "C11");
        assertEquals(carC.getCar(3).getModellType(), "C13");
        assertEquals(carC.getCar(4).getModellType(), "C10");
        assertEquals(carC.getCar(5).getModellType(), "C14");

        //SitPlace Sort
        carC.sortMaxSitPlaceLowerToUper();
        assertEquals(carC.getCar(0).getModellType(), "C12");
        assertEquals(carC.getCar(1).getModellType(), "C14");
        assertEquals(carC.getCar(2).getModellType(), "C15");
        assertEquals(carC.getCar(3).getModellType(), "C11");
        assertEquals(carC.getCar(4).getModellType(), "C13");
        assertEquals(carC.getCar(5).getModellType(), "C10");


        carC.sortMaxSitPlaceUperToLower();
        assertEquals(carC.getCar(0).getModellType(), "C10");
        assertEquals(carC.getCar(1).getModellType(), "C13");
        assertEquals(carC.getCar(2).getModellType(), "C11");
        assertEquals(carC.getCar(3).getModellType(), "C15");
        assertEquals(carC.getCar(4).getModellType(), "C14");
        assertEquals(carC.getCar(5).getModellType(), "C12");
    }
    //############################################################################
}
