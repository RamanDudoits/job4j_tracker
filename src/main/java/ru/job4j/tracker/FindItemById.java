package ru.job4j.tracker;

public class FindItemById implements UserAction {
    @Override
    public String name() {
        return "=== Find item by id ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = input.askInt("Enter id: ");
        Item item = tracker.findById(id);
        if(item != null) {
            System.out.println(" This item: " + item);
        } else {
            System.out.println("Items not protected");
        }
        return true;
    }
}
