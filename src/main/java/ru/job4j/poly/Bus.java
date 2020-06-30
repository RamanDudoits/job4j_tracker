package ru.job4j.poly;

public class Bus implements Transport {
    @Override
    public void go() {
        String city = "Minsk";
        String city2 = "Moscow";
    }

    @Override
    public void passengers(int passengers) {
        passengers = 7;
    }

    @Override
    public double price(double fuel) {
        int km = 727;
        double consumptionFuel = 8 / 100;
        fuel = km * consumptionFuel;
        return fuel * 1.78 ;
    }
}
