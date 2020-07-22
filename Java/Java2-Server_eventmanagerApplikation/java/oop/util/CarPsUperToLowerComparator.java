package oop.util;

import oop.Car;

import java.util.Comparator;

public class CarPsUperToLowerComparator implements Comparator<Car> {
    @Override
    public int compare(Car c1, Car c2){
        return -1 * c1.getPS() - c2.getPS();
    }
}
