package ru.job4j.tracker;

public class StartUI {
    public static void main(String[] args) {
        Tracker tracker = new Tracker();
        Item item = new Item();
        item.setName("Golova");
        System.out.println(tracker.findById(item.getId()));
    }
}