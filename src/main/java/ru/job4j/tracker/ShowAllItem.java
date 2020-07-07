package ru.job4j.tracker;

public class ShowAllItem implements UserAction {
    @Override
    public String name() {
        return "=== Show all items ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println(" Show all items");
        Item[] items = tracker.findAll();
        if(items.length > 0) {
            for (int i = 0; i < items.length; i++) {
                System.out.println(items[i]);
            }
        } else {
            System.out.println("Items not found");
        }
        return true;
    }
}
