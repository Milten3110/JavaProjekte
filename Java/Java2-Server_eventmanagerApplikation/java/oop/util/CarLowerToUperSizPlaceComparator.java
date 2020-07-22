package oop.util;

import oop.Car;

import java.util.Comparator;

public class CarLowerToUperSizPlaceComparator implements Comparator<Car> {
    @Override
    public int compare(Car c1, Car c2) {
        return c1.getMaxSitPlaces()- c2.getMaxSitPlaces();
    }
}
