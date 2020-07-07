package ru.job4j.tracker;

public class ReplaceItem implements UserAction {
    @Override
    public String name() {
        return "=== Replace item ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = input.askInt("Enter id: ");
        String newName = input.askStr("Enter new name: ");
        Item item = new Item(newName);
        if(tracker.replace(id, item)) {
            System.out.println("Replace successfully completed");
        } else {
            System.out.println("Replace not produced");
        }
        return true;
    }
}
